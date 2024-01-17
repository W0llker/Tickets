package com.app;

import com.app.repository.TicketRepository;
import com.app.service.TicketServiceImpl;

public class App {
    public static void main(String[] args) {
        TicketServiceImpl ticketService = new TicketServiceImpl(new TicketRepository());

        System.out.println("Минимальное время полета между городами\n" +
                "Владивосток и Тель-Авив для каждого\n" +
                "авиаперевозчика\n" + ticketService.getMinimalTimeToCityFromCity("Владивосток", "Тель-Авив"));

        System.out.println("Разницу между средней ценой и медианой для\n" +
                "полета между городами  Владивосток и Тель-Авив\n" + ticketService.differenceAvgAndMedian());

    }
}
