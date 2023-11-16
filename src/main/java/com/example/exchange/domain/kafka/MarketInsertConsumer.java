package com.example.exchange.domain.kafka;

import com.example.exchange.domain.request.InsertRequest;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MarketInsertConsumer {

    private final ExchangeService exchangeService;

    @KafkaListener(topics = "market", groupId = "market")
    public void animalConsume(InsertRequest result) throws IOException {
        System.out.println("insert consumer : "+result);
        exchangeService.insert(result);

    }
}