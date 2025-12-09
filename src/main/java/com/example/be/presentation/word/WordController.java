package com.example.be.presentation.word;

import com.example.be.application.word.WordCommandService;
import com.example.be.presentation.word.dto.WordCreateRequest;
import com.example.be.presentation.word.dto.WordResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordController {

    private final WordCommandService wordCommandService;

    public WordController(WordCommandService wordCommandService) {
        this.wordCommandService = wordCommandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WordResponse create(@RequestBody WordCreateRequest request) {
        return WordResponse.from(wordCommandService.createWord(request.wordEng(), request.wordKor()));
    }

    @GetMapping
    public List<WordResponse> findAll() {
        return wordCommandService.findAll()
                .stream()
                .map(WordResponse::from)
                .toList();
    }
}
