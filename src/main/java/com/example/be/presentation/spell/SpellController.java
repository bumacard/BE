package com.example.be.presentation.spell;

import com.example.be.application.word.WordCommandService;
import com.example.be.presentation.word.dto.WordResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spell")
public class SpellController {

    private final WordCommandService wordCommandService;

    public SpellController(WordCommandService wordCommandService) {
        this.wordCommandService = wordCommandService;
    }

    @GetMapping
    public List<WordResponse> spellQuiz() {
        return wordCommandService.findAllShuffled()
                .stream()
                .map(WordResponse::from)
                .toList();
    }
}
