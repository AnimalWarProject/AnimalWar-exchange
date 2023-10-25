package com.example.exchange.controller;

import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.domain.request.InsertRequest;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

//    @GetMapping  // 거래소 들어가면 바로 보여주는거
//    public findAllResponse findAll(){
//
//    }

    @PostMapping("/insert")
    public void insert(@RequestBody InsertRequest request){ // 거래소 등록
        exchangeService.insert(request);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteRequest request){ // 판매되면 물품 삭제 
        exchangeService.delete(request); // todo : 그리고 인벤토리에 save 보내야함
    }
}
