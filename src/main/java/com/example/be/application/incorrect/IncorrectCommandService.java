package com.example.be.application.incorrect;

import com.example.be.domain.incorrect.Incorrect;
import com.example.be.domain.incorrect.IncorrectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class IncorrectCommandService {

    private final IncorrectRepository incorrectRepository;

    public IncorrectCommandService(IncorrectRepository incorrectRepository) {
        this.incorrectRepository = incorrectRepository;
    }

    public Incorrect recordIncorrect(Long wordId) {
        return incorrectRepository.save(Incorrect.create(wordId));
    }

    public Optional<Incorrect> updateReview(Long incorrectId, LocalDateTime reviewDate, int reviewCount) {
        return incorrectRepository.findById(incorrectId)
                .map(current -> incorrectRepository.save(current.withReview(reviewDate, reviewCount)));
    }

    public Optional<Incorrect> findById(Long incorrectId) {
        return incorrectRepository.findById(incorrectId);
    }
}
