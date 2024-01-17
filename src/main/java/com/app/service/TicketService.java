package com.app.service;

import java.time.Duration;
import java.util.Map;

public interface TicketService {
    Map<String, Duration> getMinimalTimeToCityFromCity(String toCity, String fromCity);

    Double differenceAvgAndMedian();
}
