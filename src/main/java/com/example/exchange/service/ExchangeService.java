package com.example.exchange.service;

import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.domain.request.InsertRequest;
import com.example.exchange.repository.ExchangeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;

    public void insert(InsertRequest request){
        exchangeRepository.save(request.toEntity());
    }

    @Transactional
    public void delete(DeleteRequest request){
        exchangeRepository.checkById(request.itemId(), request.userId()).orElseThrow(()->new RuntimeException("없는 정보입니다."));
        exchangeRepository.deleteById(request.itemId(), request.userId());

    }

}
