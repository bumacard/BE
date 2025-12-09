package com.example.be.infrastructure.persistence.jpa.adapter;

import com.example.be.domain.word.Word;
import com.example.be.domain.word.WordRepository;
import com.example.be.infrastructure.persistence.jpa.entity.WordJpaEntity;
import com.example.be.infrastructure.persistence.jpa.repository.WordJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WordRepositoryAdapter implements WordRepository {

    private final WordJpaRepository wordJpaRepository;

    public WordRepositoryAdapter(WordJpaRepository wordJpaRepository) {
        this.wordJpaRepository = wordJpaRepository;
    }

    @Override
    public Word save(Word word) {
        WordJpaEntity saved = wordJpaRepository.save(WordJpaEntity.fromDomain(word));
        return saved.toDomain();
    }

    @Override
    public Optional<Word> findById(Long id) {
        return wordJpaRepository.findById(id).map(WordJpaEntity::toDomain);
    }

    @Override
    public List<Word> findAll() {
        return wordJpaRepository.findAll()
                .stream()
                .map(WordJpaEntity::toDomain)
                .toList();
    }

    @Override
    public List<Word> findAllRandomOrder() {
        return wordJpaRepository.findAllRandomOrder()
                .stream()
                .map(WordJpaEntity::toDomain)
                .toList();
    }
}
