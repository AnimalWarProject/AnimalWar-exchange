package com.example.exchange.domain.request;

import com.example.exchange.domain.entity.Exchange;

import java.util.UUID;

public record InsertRequest(
        UUID userId,
        UUID itemId,
        String name,
        String grade,
        String type,
        Integer buff,
        Integer price,
        String division
) {
    public Exchange toEntity(){
        return Exchange
                .builder()
                .userId(userId)
                .itemId(itemId)
                .name(name)
                .grade(grade)
                .type(type)
                .buff(buff)
                .price(price)
                .division(division)
                .build();
    }
}
