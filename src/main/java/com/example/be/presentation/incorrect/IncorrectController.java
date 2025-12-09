package com.example.be.presentation.incorrect;

import com.example.be.application.incorrect.IncorrectCommandService;
import com.example.be.presentation.incorrect.dto.IncorrectCreateRequest;
import com.example.be.presentation.incorrect.dto.IncorrectResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/incorrect")
public class IncorrectController {

    private final IncorrectCommandService incorrectCommandService;

    public IncorrectController(IncorrectCommandService incorrectCommandService) {
        this.incorrectCommandService = incorrectCommandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncorrectResponse create(@RequestBody IncorrectCreateRequest request) {
        return IncorrectResponse.from(incorrectCommandService.recordIncorrect(request.wordId()));
    }

    @GetMapping("/{incorrectId}")
    public IncorrectResponse findById(@PathVariable Long incorrectId) {
        return incorrectCommandService.findById(incorrectId)
                .map(IncorrectResponse::from)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "incorrect not found"));
    }
}
