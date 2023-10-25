package com.example.exchange.controller;

import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.domain.request.FindRequest;
import com.example.exchange.domain.request.InsertRequest;
import com.example.exchange.domain.response.FindAllResponse;
import com.example.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/all")  // 거래소 들어가면 바로 보여주는거
    public List<FindAllResponse> findAll(){
        return exchangeService.findAll();
    }
//    @PostMapping("/filter") // 필터
//    public List<FindAllResponse> findOrderBy(@RequestBody FindRequest request){
//        return exchangeService.findFilter(request);
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
