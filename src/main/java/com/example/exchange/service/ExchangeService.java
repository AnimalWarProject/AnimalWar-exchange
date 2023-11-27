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
@Transactional
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
                e.getImagePath(),
                e.getBtnState()
        )).toList();
    }

    public List<FindAllResponse> findAllByFilter(String type){ // serchBox에 있는 타입 필터
        List<Exchange> byType = exchangeRepository.findByTypes(type);
        return byType.stream().map((e)->new FindAllResponse(
                e.getUserId(),
                e.getItemId(),
                e.getName(),
                e.getGrade(),
                e.getType(),
                e.getBuff(),
                e.getPrice(),
                e.getImagePath(),
                e.getBtnState()
        )).toList();
    }

    public List<FindAllResponse> search(String word){ // 검색기능
        List<Exchange> search = exchangeRepository.searchByWord(word);
        return search.stream().map((e)-> new FindAllResponse(
                e.getUserId(),
                e.getItemId(),
                e.getName(),
                e.getGrade(),
                e.getType(),
                e.getBuff(),
                e.getPrice(),
                e.getImagePath(),
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
        exchangeRepository.checkById(request.itemId(), request.userUUID()).orElseThrow(()->new RuntimeException("없는 정보입니다."));
        exchangeRepository.deleteById(request.itemId(), request.userUUID());

    }

}
