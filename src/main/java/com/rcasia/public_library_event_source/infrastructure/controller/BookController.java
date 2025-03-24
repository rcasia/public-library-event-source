package com.rcasia.public_library_event_source.infrastructure.controller;


import com.rcasia.public_library_event_source.domain.commands.LendBookCommand;
import com.rcasia.public_library_event_source.domain.commands.RegisterBookCommand;
import com.rcasia.public_library_event_source.domain.model.Book;
import com.rcasia.public_library_event_source.domain.usecases.BookGetAllUseCase;
import com.rcasia.public_library_event_source.domain.usecases.BookLendUseCase;
import com.rcasia.public_library_event_source.domain.usecases.BookRegisterUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookGetAllUseCase bookGetAllUseCase;

    private BookRegisterUseCase bookRegisterUseCase;

    private BookLendUseCase bookLendUseCase;

    public BookController(BookGetAllUseCase bookGetAllUseCase, BookRegisterUseCase bookRegisterUseCase, BookLendUseCase bookLendUseCase) {
        this.bookGetAllUseCase = bookGetAllUseCase;
        this.bookRegisterUseCase = bookRegisterUseCase;
        this.bookLendUseCase = bookLendUseCase;
    }

    @GetMapping
    List<Book> getAllBooks(){
        return this.bookGetAllUseCase.getAllBooks();
    }

    @PostMapping
    Book registerBook(@RequestBody RegisterBookCommand command) {
        return this.bookRegisterUseCase.registerBook(command);
    }

    @PostMapping("/{book-id}/lend")
    void lendBook(@RequestBody LendBookCommand command) {
        this.bookLendUseCase.lendBook(command);
    }

}
