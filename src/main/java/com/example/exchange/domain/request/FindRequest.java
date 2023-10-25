package com.example.exchange.domain.request;

public record FindRequest(String grade,
                          String type,
                          String word,
                          String orderBy) {
}
