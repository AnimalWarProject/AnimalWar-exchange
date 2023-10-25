package com.example.exchange.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity @Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exchange")
public class Exchange {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID userId;
    private UUID itemId;
    private String name; // 이름
    private String grade; // 등급 동물은 Legend, unique... 건물은 희귀한 ...
    private String type; // 동물은 과 종류, 건물은 Null
    private Integer buff; // 강화 수
    private Integer price; // 가격
    private String division; // 구분 건물 혹은 동물인지 확인 todo : 프론트에서 넘겨줄것

}
