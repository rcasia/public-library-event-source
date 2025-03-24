package com.rcasia.public_library_event_source.domain.usecases;

import com.rcasia.public_library_event_source.domain.model.Book;

import java.util.List;

public interface BookGetAllUseCase {
    List<Book> getAllBooks();
}
