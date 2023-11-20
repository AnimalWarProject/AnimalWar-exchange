package com.example.exchange.domain.request;

import com.example.exchange.domain.entity.Exchange;

import java.util.UUID;

public record BuildingInsertRequest(
        UUID userUUID,
        Long itemId,
        String name,
        String grade,
        String species,
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
                .price(price)
                .btnState(true)
                .build();
    }
}
