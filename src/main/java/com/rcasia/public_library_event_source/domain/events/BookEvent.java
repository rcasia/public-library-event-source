package com.rcasia.public_library_event_source.domain.events;

public sealed interface BookEvent permits BookEvent.BookLended, BookEvent.BookRegistered {

    String bookId();

    record BookRegistered(String bookId, String bookTitle, String actor) implements BookEvent{}

    record BookLended(String bookId, String lender) implements BookEvent {}

}

