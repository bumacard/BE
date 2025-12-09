package com.example.be.infrastructure.persistence.jpa.entity;

import com.example.be.domain.incorrect.Incorrect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "incorrect")
public class IncorrectJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incorrect_id")
    private Long id;

    @Column(name = "incorrect_date", nullable = false)
    private LocalDateTime incorrectDate;

    @Column(name = "last_review_date")
    private LocalDateTime lastReviewDate;

    @Column(name = "review_count", nullable = false)
    private int reviewCount;

    @Column(name = "word_id", nullable = false)
    private Long wordId;

    protected IncorrectJpaEntity() {
        // for JPA
    }

    private IncorrectJpaEntity(Long id,
                               LocalDateTime incorrectDate,
                               LocalDateTime lastReviewDate,
                               int reviewCount,
                               Long wordId) {
        this.id = id;
        this.incorrectDate = incorrectDate;
        this.lastReviewDate = lastReviewDate;
        this.reviewCount = reviewCount;
        this.wordId = wordId;
    }

    public static IncorrectJpaEntity fromDomain(Incorrect incorrect) {
        return new IncorrectJpaEntity(
                incorrect.id(),
                incorrect.incorrectDate(),
                incorrect.lastReviewDate(),
                incorrect.reviewCount(),
                incorrect.wordId()
        );
    }

    public Incorrect toDomain() {
        return new Incorrect(id, incorrectDate, lastReviewDate, reviewCount, wordId);
    }
}
