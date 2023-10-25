package com.example.exchange.repository;

import com.example.exchange.domain.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    @Query("SELECT E FROM Exchange E WHERE E.itemId=:itemId AND E.userId=:userId")
    Optional<Exchange> checkById(UUID itemId, UUID userId);

    @Modifying
    @Query("DELETE FROM Exchange E WHERE E.itemId=:itemId AND E.userId=:userId")
    void deleteById(UUID itemId, UUID userId);

}
