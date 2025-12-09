package com.example.be.infrastructure.persistence.jpa.repository;

import com.example.be.infrastructure.persistence.jpa.entity.IncorrectJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncorrectJpaRepository extends JpaRepository<IncorrectJpaEntity, Long> {
}
