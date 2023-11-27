package com.example.exchange.controller;

import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.domain.request.AnimalInsertRequest;
import com.example.exchange.domain.response.FindAllResponse;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/market")
public class ExchangeController {

    private final ExchangeService exchangeService;
    @GetMapping("/all")  // 거래소 들어가면 바로 보여주는거
    public List<FindAllResponse> findAll(){
        return exchangeService.findAll();
    }
    @PostMapping("/filter/{type}") // type 을 받아서 조회결과를 보여줌
    public List<FindAllResponse> findAllByFilter(@PathVariable("type") String type){
        return exchangeService.findAllByFilter(type);
    }
    @PostMapping("/search/{word}") // 검색기능
    public List<FindAllResponse> search(@PathVariable("word") String word){
        return exchangeService.search(word);
    }

}
