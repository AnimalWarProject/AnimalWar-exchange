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
                e.getPrice(),
                e.getDivision()
        )).toList();
    }

//    public List<FindAllResponse> findFilter(FindRequest request){
//        if (request.word().isEmpty()){ // grade와 type을 둘다 받았을때
//            if (request.grade().isEmpty()){ // type만 받았을때
//                List<FindAllResponse> filterByType = exchangeRepository.findFilterByType(request.type());
//                return filterByType;
//            }else {
//                List<FindAllResponse> filterByGrade = exchangeRepository.findFilterByGrade(request.grade());
//                return filterByGrade;
//            }
//        }else {
//            List<FindAllResponse> search = exchangeRepository.search(request.word());
//            return search;
//        }
//    }

    public void insert(InsertRequest request){
        exchangeRepository.save(request.toEntity());
    }

    @Transactional
    public void delete(DeleteRequest request){
        exchangeRepository.checkById(request.itemId(), request.userId()).orElseThrow(()->new RuntimeException("없는 정보입니다."));
        exchangeRepository.deleteById(request.itemId(), request.userId());

    }

}
