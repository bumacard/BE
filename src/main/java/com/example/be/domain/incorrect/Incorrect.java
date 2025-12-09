package com.example.be.domain.incorrect;

import java.time.LocalDateTime;

public record Incorrect(
        Long id,
        LocalDateTime incorrectDate,
        LocalDateTime lastReviewDate,
        int reviewCount,
        Long wordId
) {

    public Incorrect {
        if (wordId == null) {
            throw new IllegalArgumentException("wordId is required");
        }
        if (incorrectDate == null) {
            incorrectDate = LocalDateTime.now();
        }
        if (reviewCount < 0) {
            throw new IllegalArgumentException("reviewCount cannot be negative");
        }
    }

    public static Incorrect create(Long wordId) {
        return new Incorrect(null, LocalDateTime.now(), null, 0, wordId);
    }

    public Incorrect withReview(LocalDateTime reviewedAt, int newReviewCount) {
        return new Incorrect(id, incorrectDate, reviewedAt, newReviewCount, wordId);
    }
}
