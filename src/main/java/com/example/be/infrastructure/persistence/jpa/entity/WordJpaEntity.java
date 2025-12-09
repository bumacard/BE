package com.example.be.infrastructure.persistence.jpa.entity;

import com.example.be.domain.word.Word;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "words")
public class WordJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long id;

    @Column(name = "word_eng", nullable = false, columnDefinition = "TEXT")
    private String wordEng;

    @Column(name = "word_kor", nullable = false, columnDefinition = "TEXT")
    private String wordKor;

    protected WordJpaEntity() {
        // for JPA
    }

    private WordJpaEntity(Long id, String wordEng, String wordKor) {
        this.id = id;
        this.wordEng = wordEng;
        this.wordKor = wordKor;
    }

    public static WordJpaEntity fromDomain(Word word) {
        return new WordJpaEntity(word.id(), word.wordEng(), word.wordKor());
    }

    public Word toDomain() {
        return new Word(id, wordEng, wordKor);
    }
}
