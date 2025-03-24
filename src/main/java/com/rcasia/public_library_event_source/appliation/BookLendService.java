package com.rcasia.public_library_event_source.appliation;

import com.rcasia.public_library_event_source.domain.commands.LendBookCommand;
import com.rcasia.public_library_event_source.domain.events.BookEvent;
import com.rcasia.public_library_event_source.domain.model.Book;
import com.rcasia.public_library_event_source.domain.ports.BookFindPort;
import com.rcasia.public_library_event_source.domain.ports.BookSavePort;
import com.rcasia.public_library_event_source.domain.usecases.BookLendUseCase;
import org.springframework.stereotype.Service;

@Service
public class BookLendService implements BookLendUseCase {

    private final BookFindPort bookFindPort;
    private final BookSavePort bookSavePort;

    public BookLendService(BookFindPort bookFindPort, BookSavePort bookSavePort) {
        this.bookFindPort = bookFindPort;
        this.bookSavePort = bookSavePort;
    }

    @Override
    public void lendBook(LendBookCommand command) {
        Book book = this.bookFindPort.findById(command.bookId())
                .orElseThrow(() -> new RuntimeException("Cannot lend a non existent book"));

        book.apply(new BookEvent.BookLended(command.bookId(), command.lender()));


        bookSavePort.save(book);
    }
}
