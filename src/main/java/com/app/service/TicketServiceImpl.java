package com.app.service;

import com.app.entity.Ticket;
import com.app.repository.TicketRepository;
import com.app.utils.TimeUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.*;

public class TicketServiceImpl implements TicketService {
    private TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Map<String, Duration> getMinimalTimeToCityFromCity(String fromCity, String toCity) {
        Map<String, Duration> ticketHashMap = new HashMap<>();
        for (Ticket ticket : repository.getTickets()) {
            if (ticket.getToCity().equals(toCity) && ticket.getFromCity().equals(fromCity)) {
                ticketHashMap = timeCheck(ticketHashMap, TimeUtils.getDurationOnTicket(ticket), ticket);
            }
        }
        return ticketHashMap;
    }

    @Override
    public BigDecimal differenceAvgAndMedian() {
        List<Ticket> tickets = repository.getTickets();
        tickets.sort(Comparator.comparingInt(a -> a.getPrice().intValue()));
        BigDecimal median = getMedian(tickets);
        List<Double> doubles = tickets.stream().map(ticket -> ticket.getPrice().doubleValue()).toList();
        OptionalDouble average = doubles.stream().mapToDouble(value -> value).average();
        if (average.isEmpty()) {
            throw new RuntimeException("Среднее значение = null");
        }
        return BigDecimal.valueOf(average.getAsDouble()).subtract(median).setScale(2, RoundingMode.DOWN);
    }

    private Map<String, Duration> timeCheck(Map<String, Duration> hashMap, Duration flightDuration, Ticket ticket) {
        if (hashMap.containsKey(ticket.getAirTransporter())) {
            Duration currentMin = hashMap.get(ticket.getAirTransporter());
            if (TimeUtils.TimeCompare(currentMin, flightDuration) > 0) {
                hashMap.remove(ticket.getAirTransporter());
                hashMap.put(ticket.getAirTransporter(), flightDuration);
            }
        } else
            hashMap.put(ticket.getAirTransporter(), flightDuration);
        return hashMap;
    }

    private BigDecimal getMedian(List<Ticket> tickets) {
        int length = tickets.size();
        if (length % 2 == 0) {
            double intermediateResult = tickets.get(length / 2 - 1).getPrice().doubleValue() + tickets.get((length / 2)).getPrice().doubleValue();
            return BigDecimal.valueOf(intermediateResult / 2);
        } else {
            return BigDecimal.valueOf(tickets.get((length / 2)).getPrice().doubleValue());
        }
    }
}
