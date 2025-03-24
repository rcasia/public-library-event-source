package com.rcasia.public_library_event_source.infrastructure.persistance;

import com.rcasia.public_library_event_source.domain.model.Book;
import com.rcasia.public_library_event_source.domain.events.BookEvent;
import com.rcasia.public_library_event_source.domain.ports.BookFindPort;
import com.rcasia.public_library_event_source.domain.ports.BookGetAllPort;
import com.rcasia.public_library_event_source.domain.ports.BookSavePort;
import com.rcasia.public_library_event_source.domain.ports.BookStatsGetGlobalStatsPort;
import com.rcasia.public_library_event_source.domain.projections.BookStats;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class BookInMemoryRepository implements BookSavePort, BookFindPort, BookGetAllPort, BookStatsGetGlobalStatsPort {

    HashMap<String, List<BookEvent>> bookEventLog = new HashMap<>();

    @Override
    public Book save(Book book) {
        bookEventLog.put(book.id(), book.events());
        return book;
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(bookEventLog.get(id)).map(Book::new);
    }

    @Override
    public List<Book> getAll() {
        return bookEventLog.values().stream()
                .map(Book::new)
                .toList();
    }

    @Override
    public BookStats getGlobalStats() {
        return new BookStats(bookEventLog.values());
    }
}
