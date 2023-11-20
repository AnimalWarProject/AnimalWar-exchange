package com.example.exchange.domain.kafka;

import com.example.exchange.domain.request.AnimalInsertRequest;
import com.example.exchange.domain.request.BuyBtnRequest;
import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MarketInsertConsumer {

    private final ExchangeService exchangeService;

    @KafkaListener(topics = "market-animal", groupId = "market")
    public void animalConsume(AnimalInsertRequest result) throws IOException {
        exchangeService.insert(result);
    }

    @KafkaListener(topics = "market-building", groupId = "market")
    public void buildingConsume(AnimalInsertRequest result) throws IOException {
        exchangeService.insert(result);
    }

    @KafkaListener(topics = "market-buy-item", groupId = "market")
    public void buyAnimalConsume(BuyBtnRequest request) throws IOException {
        System.out.println("buy A consumer : "+request);
        exchangeService.buyItem(request);
    }

    @KafkaListener(topics = "market-cancel-item", groupId = "market")
    public void cancelItemConsume(DeleteRequest request) throws IOException {
        System.out.println("cancel A consumer : "+request);
        exchangeService.delete(request);
    }




}