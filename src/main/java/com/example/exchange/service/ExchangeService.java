package com.example.exchange.service;

import com.example.exchange.domain.entity.Exchange;
import com.example.exchange.domain.request.BuyBtnRequest;
import com.example.exchange.domain.request.DeleteRequest;
import com.example.exchange.domain.request.AnimalInsertRequest;
import com.example.exchange.domain.response.FindAllResponse;
import com.example.exchange.repository.ExchangeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                e.getBtnState()
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
                e.getPrice(),
                e.getBtnState()
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
                e.getPrice(),
                e.getBtnState())).toList();
    }

    public void insert(AnimalInsertRequest request){
        exchangeRepository.save(request.toEntity());
    }

    public void buyItem(BuyBtnRequest request){
        Optional<Exchange> byIdAndItemId = exchangeRepository.findByIdAndItemId(request.userUUID(), request.itemId());
        if (byIdAndItemId.isPresent()){
            Exchange exchange = byIdAndItemId.get();
            exchange.setBtnState(false);
        }else {
            System.out.println("잘못된 정보입니다. buy Item");
        }
    }

    @Transactional
    public void delete(DeleteRequest request){
        exchangeRepository.checkById(request.itemId(), request.userId()).orElseThrow(()->new RuntimeException("없는 정보입니다."));
        exchangeRepository.deleteById(request.itemId(), request.userId());

    }

}
