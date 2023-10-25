package com.example.exchange.domain.response;

import java.util.UUID;

public record FindAllResponse(
        UUID userId,
        UUID itemId,
        String name,
        String grade,
        String type,
        Integer buff,
        Integer price,
        String division
) {
}
