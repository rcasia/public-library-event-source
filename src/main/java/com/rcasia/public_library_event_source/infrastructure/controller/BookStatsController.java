package com.rcasia.public_library_event_source.infrastructure.controller;


import com.rcasia.public_library_event_source.domain.projections.BookStats;
import com.rcasia.public_library_event_source.domain.usecases.BookGetGlobalStatsUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books-stats")
public class BookStatsController {

    private final BookGetGlobalStatsUseCase bookGetGlobalStatsUseCase;

    public BookStatsController(BookGetGlobalStatsUseCase bookGetGlobalStatsUseCase) {
        this.bookGetGlobalStatsUseCase = bookGetGlobalStatsUseCase;
    }

    @GetMapping
    BookStats getGlobalBookStats(){
        return this.bookGetGlobalStatsUseCase.getGlobalStats();
    }

}
