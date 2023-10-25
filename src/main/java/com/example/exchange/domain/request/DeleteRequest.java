package com.example.exchange.domain.request;

import java.util.UUID;

public record DeleteRequest(
        UUID userId,
        UUID itemId
) {

}
