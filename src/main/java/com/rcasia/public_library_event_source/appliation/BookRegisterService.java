package com.rcasia.public_library_event_source.appliation;

import com.rcasia.public_library_event_source.domain.commands.RegisterBookCommand;
import com.rcasia.public_library_event_source.domain.events.BookEvent;
import com.rcasia.public_library_event_source.domain.model.Book;
import com.rcasia.public_library_event_source.domain.ports.BookFindPort;
import com.rcasia.public_library_event_source.domain.ports.BookSavePort;
import com.rcasia.public_library_event_source.domain.usecases.BookRegisterUseCase;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class BookRegisterService implements BookRegisterUseCase {
    private BookSavePort bookSavePort;
    private BookFindPort bookFindPort;

    public BookRegisterService(BookSavePort bookSavePort, BookFindPort bookFindPort) {
        this.bookSavePort = bookSavePort;
        this.bookFindPort = bookFindPort;
    }

    @Override
    public Book registerBook(RegisterBookCommand command) {

        if (bookFindPort.findById(command.id()).isPresent()) {
            throw new RuntimeException("Cannot register book with an already existing id");
        }

        Book book = new Book(new BookEvent.BookRegistered(command.id(), command.title(), command.actor()));
        return this.bookSavePort.save(book);
    }
}
