package com.example.exchange.domain.request;

import java.util.UUID;

public record BuyBtnRequest(
        UUID userUUID,
        Long itemId
) {
}
