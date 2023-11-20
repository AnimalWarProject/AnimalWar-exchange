package com.example.exchange.repository;

import com.example.exchange.domain.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExchangeRepository extends JpaRepository<Exchange, UUID> {

    @Query("SELECT E FROM Exchange E WHERE E.name LIKE %:word%") // 검색기능
    List<Exchange> searchByWord(String word);

    @Query("SELECT E FROM Exchange E WHERE E.type=:type")// type만 받았을때 개 고양이 새 쥐 생선
    List<Exchange> findByTypes(String type);

    @Query("SELECT E FROM Exchange E WHERE E.itemId=:itemId AND E.userId=:userId")
    Optional<Exchange> checkById(Long itemId, UUID userId);

    @Query("SELECT E FROM Exchange E WHERE E.userId=:userUUID AND E.itemId=:itemId")
    Optional<Exchange> findByIdAndItemId(UUID userUUID, Long itemId);

    @Modifying
    @Query("DELETE FROM Exchange E WHERE E.itemId=:itemId AND E.userId=:userId")
    void deleteById(Long itemId, UUID userId);


}
