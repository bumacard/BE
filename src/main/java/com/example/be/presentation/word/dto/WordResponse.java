package com.example.be.presentation.word.dto;

import com.example.be.domain.word.Word;

public record WordResponse(Long id, String wordEng, String wordKor) {

    public static WordResponse from(Word word) {
        return new WordResponse(word.id(), word.wordEng(), word.wordKor());
    }
}
