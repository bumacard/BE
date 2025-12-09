package com.example.be.domain.word;

import java.util.List;
import java.util.Optional;

public interface WordRepository {

    Word save(Word word);

    Optional<Word> findById(Long id);

    List<Word> findAll();

    List<Word> findAllRandomOrder();
}
