package com.app.repository;

import com.app.entity.Ticket;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    public List<Ticket> getTickets() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Ticket> tickets = new ArrayList<>(List.of(mapper.readValue(new File("src/main/resources/tickets.json"), Ticket[].class)));
            return tickets;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
