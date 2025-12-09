package com.example.be.application.word;

import com.example.be.domain.word.Word;
import com.example.be.domain.word.WordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCommandService {

    private final WordRepository wordRepository;

    public WordCommandService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word createWord(String wordEng, String wordKor) {
        return wordRepository.save(Word.create(wordEng, wordKor));
    }

    public List<Word> findAll() {
        return wordRepository.findAll();
    }

    public List<Word> findAllShuffled() {
        return wordRepository.findAllRandomOrder();
    }
}
