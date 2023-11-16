package com.example.exchange.domain.request;

import com.example.exchange.domain.entity.Exchange;

import java.util.UUID;

public record InsertRequest(
        UUID userUUID,
        Long itemId,
        String name,
        String grade,
        String species,
        Integer buff,
        Integer price
) {
    public Exchange toEntity(){
        return Exchange
                .builder()
                .userId(userUUID)
                .itemId(itemId)
                .name(name)
                .grade(grade)
                .type(species)
                .buff(buff)
                .price(price)
                .build();
    }
}
