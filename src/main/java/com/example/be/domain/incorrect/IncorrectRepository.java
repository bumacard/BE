package com.example.be.domain.incorrect;

import java.util.Optional;

public interface IncorrectRepository {

    Incorrect save(Incorrect incorrect);

    Optional<Incorrect> findById(Long id);
}
