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
        System.out.println("받는타입 " + type);
        return exchangeService.findAllByFilter(type);
    }

    @PostMapping("/search/{word}") // 검색기능
    public List<FindAllResponse> search(@PathVariable("word") String word){
        return exchangeService.search(word);
    }

//    @PostMapping("/insert")
//    public void insert(@RequestBody AnimalInsertRequest request){ // 거래소 등록
//        exchangeService.insert(request);
//    }

//    @PostMapping("/delete")
//    public void delete(@RequestBody DeleteRequest request){ // 판매되면 물품 삭제
//        System.out.println(request.userId());
//        System.out.println(request.itemId());
//        exchangeService.delete(request); // todo : 그리고 인벤토리에 save 보내야함
//    }
}
