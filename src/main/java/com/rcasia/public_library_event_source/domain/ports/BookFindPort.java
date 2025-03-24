package com.rcasia.public_library_event_source.domain.ports;

import com.rcasia.public_library_event_source.domain.model.Book;

import java.util.Optional;

public interface BookFindPort {
    Optional<Book> findById(String id);
}
