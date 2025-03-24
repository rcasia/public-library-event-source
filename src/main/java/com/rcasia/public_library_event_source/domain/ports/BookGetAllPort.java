package com.rcasia.public_library_event_source.domain.ports;

import com.rcasia.public_library_event_source.domain.model.Book;

import java.util.List;

public interface BookGetAllPort {
    List<Book> getAll();
}
