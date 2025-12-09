package com.example.be.infrastructure.persistence.jpa.adapter;

import com.example.be.domain.incorrect.Incorrect;
import com.example.be.domain.incorrect.IncorrectRepository;
import com.example.be.infrastructure.persistence.jpa.entity.IncorrectJpaEntity;
import com.example.be.infrastructure.persistence.jpa.repository.IncorrectJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class IncorrectRepositoryAdapter implements IncorrectRepository {

    private final IncorrectJpaRepository incorrectJpaRepository;

    public IncorrectRepositoryAdapter(IncorrectJpaRepository incorrectJpaRepository) {
        this.incorrectJpaRepository = incorrectJpaRepository;
    }

    @Override
    public Incorrect save(Incorrect incorrect) {
        IncorrectJpaEntity saved = incorrectJpaRepository.save(IncorrectJpaEntity.fromDomain(incorrect));
        return saved.toDomain();
    }

    @Override
    public Optional<Incorrect> findById(Long id) {
        return incorrectJpaRepository.findById(id).map(IncorrectJpaEntity::toDomain);
    }
}
