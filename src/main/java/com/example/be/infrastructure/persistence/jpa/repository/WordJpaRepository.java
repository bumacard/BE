package com.example.be.infrastructure.persistence.jpa.repository;

import com.example.be.infrastructure.persistence.jpa.entity.WordJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordJpaRepository extends JpaRepository<WordJpaEntity, Long> {

    @Query(value = "SELECT * FROM words ORDER BY RAND()", nativeQuery = true)
    List<WordJpaEntity> findAllRandomOrder();
}
