package com.example.be.domain.word;

public record Word(Long id, String wordEng, String wordKor) {

    public Word {
        if (wordEng == null || wordEng.isBlank()) {
            throw new IllegalArgumentException("wordEng is required");
        }
        if (wordKor == null || wordKor.isBlank()) {
            throw new IllegalArgumentException("wordKor is required");
        }
    }

    public static Word create(String wordEng, String wordKor) {
        return new Word(null, wordEng, wordKor);
    }

    public Word withId(Long newId) {
        return new Word(newId, wordEng, wordKor);
    }
}
