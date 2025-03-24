package com.rcasia.public_library_event_source.appliation;

import com.rcasia.public_library_event_source.domain.model.Book;
import com.rcasia.public_library_event_source.domain.ports.BookGetAllPort;
import com.rcasia.public_library_event_source.domain.usecases.BookGetAllUseCase;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookGetAllService implements BookGetAllUseCase {

    private final BookGetAllPort bookGetAllPort;

    public BookGetAllService(BookGetAllPort bookGetAllPort) {
        this.bookGetAllPort = bookGetAllPort;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookGetAllPort.getAll();
    }
}
