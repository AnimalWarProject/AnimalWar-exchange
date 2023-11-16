package com.example.exchange.service;

import com.example.exchange.domain.entity.Exchange;
import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.domain.request.FindRequest;
import com.example.exchange.domain.request.InsertRequest;
import com.example.exchange.domain.response.FindAllResponse;
import com.example.exchange.repository.ExchangeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    public List<FindAllResponse> findAll(){
        List<Exchange> all = exchangeRepository.findAll();
        return all.stream().map((e)->new FindAllResponse(
                e.getUserId(),
                e.getItemId(),
                e.getName(),
                e.getGrade(),
                e.getType(),
                e.getBuff(),
                e.getPrice()
        )).toList();
    }

    public List<FindAllResponse> findAllByFilter(String type){ // serchBox에 있는 타입 필터
        List<Exchange> byType = exchangeRepository.findByTypes(type);
        System.out.println("type : " + type);
        System.out.println("결과 : " + byType);
        return byType.stream().map((e)->new FindAllResponse(
                e.getUserId(),
                e.getItemId(),
                e.getName(),
                e.getGrade(),
                e.getType(),
                e.getBuff(),
                e.getPrice()
        )).toList();
    }

    public List<FindAllResponse> search(String word){ // 검색기능
        List<Exchange> search = exchangeRepository.searchByWord(word);
        System.out.println("검색 글자 : " + word);
        System.out.println("결과 : " + search);
        return search.stream().map((e)-> new FindAllResponse(
                e.getUserId(),
                e.getItemId(),
                e.getName(),
                e.getGrade(),
                e.getType(),
                e.getBuff(),
                e.getPrice())).toList();
    }

    public void insert(InsertRequest request){
        exchangeRepository.save(request.toEntity());
    }

    @Transactional
    public void delete(DeleteRequest request){
        exchangeRepository.checkById(request.itemId(), request.userId()).orElseThrow(()->new RuntimeException("없는 정보입니다."));
        exchangeRepository.deleteById(request.itemId(), request.userId());

    }

}
