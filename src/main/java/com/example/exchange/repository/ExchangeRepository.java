package com.example.exchange.repository;

import com.example.exchange.domain.entity.Exchange;
import com.example.exchange.domain.response.FindAllResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

//    @Query("SELECT E FROM Exchange E WHERE E.name LIKE %:word%") // 검색기능
//    List<FindAllResponse> search(String word);
//
//    @Query("SELECT E FROM Exchange E WHERE E.grade=:grade AND E.type=:type") // grade와 type을 둘다 받았을때
//    List<FindAllResponse> findFilter(String grade, String type);
//
//    @Query("SELECT E FROM Exchange E WHERE E.type=:type") // type만 받았을때
//    List<FindAllResponse> findFilterByType(String type);
//
//    @Query("SELECT E FROM Exchange E WHERE E.grade=:grade") // grade만 받았을때
//    List<FindAllResponse> findFilterByGrade(String grade);

    @Query("SELECT E FROM Exchange E WHERE E.itemId=:itemId AND E.userId=:userId")
    Optional<Exchange> checkById(UUID itemId, UUID userId);

    @Modifying
    @Query("DELETE FROM Exchange E WHERE E.itemId=:itemId AND E.userId=:userId")
    void deleteById(UUID itemId, UUID userId);

}
