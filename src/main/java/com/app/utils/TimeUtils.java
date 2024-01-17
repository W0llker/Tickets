package com.app.utils;

import com.app.entity.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeUtils {
    private static final ZoneId VLADIVOSTOK = ZoneId.of("Asia/Vladivostok");
    private static final ZoneId TEL_AVIV_ZONE = ZoneId.of("Asia/Jerusalem");
    public static Duration getDurationOnTicket(Ticket ticket) {
        LocalDateTime departure = ticket.getDeparture().atZone(VLADIVOSTOK).toLocalDateTime();
        LocalDateTime arrival = ticket.getArrival().atZone(TEL_AVIV_ZONE).toLocalDateTime();
        return Duration.between(departure, arrival);
    }
    public static int TimeCompare(Duration current,Duration next) {
        return current.compareTo(next);
    }
}
