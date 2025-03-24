package com.rcasia.public_library_event_source.infrastructure;

import com.rcasia.public_library_event_source.domain.model.Book;
import com.rcasia.public_library_event_source.domain.events.BookEvent;
import com.rcasia.public_library_event_source.infrastructure.persistance.BookInMemoryRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BookInMemoryRepositoryTest {

    @Test
    void shouldSaveAndGetBook() {
        var repo = new BookInMemoryRepository();

        Book book = new Book(List.of(new BookEvent.BookRegistered("1", "Pedro Páramo", "system")));
        var savedBook = repo.save(book);

        var foundBook = repo.findById(savedBook.id());

        assertThat(
                foundBook.get()).usingRecursiveComparison()
                .isEqualTo(savedBook);
    }
}
