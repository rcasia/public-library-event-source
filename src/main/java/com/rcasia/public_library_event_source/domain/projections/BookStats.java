package com.rcasia.public_library_event_source.domain.projections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rcasia.public_library_event_source.domain.events.BookEvent;

import java.util.Collection;
import java.util.List;

public class BookStats {

    @JsonProperty("bookCount")
    long bookCount;

    @JsonProperty("availableBooks")
    long availableBooks;

    public BookStats(Collection<List<BookEvent>> values) {
        this.bookCount = values.size();
        this.availableBooks = values.stream()
                .filter(bookEvents -> {
                            var lastEvent = bookEvents.getLast();
                            return !(lastEvent instanceof BookEvent.BookLended);
                        })
                .count();
    }
}
