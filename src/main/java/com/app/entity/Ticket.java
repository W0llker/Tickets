package com.app.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private String airTransporter;
    private String fromCity;
    private String toCity;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(String airTransporter, String fromCity, String toCity, LocalDateTime departure, LocalDateTime arrival, BigDecimal price) {
        this.airTransporter = airTransporter;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getAirTransporter() {
        return airTransporter;
    }

    public void setAirTransporter(String airTransporter) {
        this.airTransporter = airTransporter;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return airTransporter.equals(ticket.airTransporter) && fromCity.equals(ticket.fromCity) && toCity.equals(ticket.toCity) && departure.equals(ticket.departure) && arrival.equals(ticket.arrival) && price.equals(ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airTransporter, fromCity, toCity, departure, arrival, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "airTransporter='" + airTransporter + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", price=" + price +
                '}';
    }
}
