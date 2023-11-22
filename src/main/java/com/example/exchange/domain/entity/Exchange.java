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
    private Long itemId;
    private String name; // 이름
    private String grade; // 등급 동물은 Legend, unique... 건물은 희귀한 ...
    private String type;
    private Integer buff; // 강화 수
    private Integer price; // 가격
    private String imagePath; // 이미지 경로
    private Boolean btnState; // 구매버튼 상태 즉, 구매가능상태
}
