package com.rcasia.public_library_event_source.domain.ports;

import com.rcasia.public_library_event_source.domain.model.Book;

public interface BookSavePort {
    Book save(Book book);
}
