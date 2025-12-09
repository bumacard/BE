package com.example.be.presentation.incorrect.dto;

import com.example.be.domain.incorrect.Incorrect;

import java.time.LocalDateTime;

public record IncorrectResponse(
        Long id,
        LocalDateTime incorrectDate,
        LocalDateTime lastReviewDate,
        int reviewCount,
        Long wordId
) {

    public static IncorrectResponse from(Incorrect incorrect) {
        return new IncorrectResponse(
                incorrect.id(),
                incorrect.incorrectDate(),
                incorrect.lastReviewDate(),
                incorrect.reviewCount(),
                incorrect.wordId()
        );
    }
}
