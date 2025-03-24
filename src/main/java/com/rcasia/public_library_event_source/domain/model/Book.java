package com.rcasia.public_library_event_source.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rcasia.public_library_event_source.domain.events.BookEvent;

import java.util.ArrayList;
import java.util.List;

import static com.rcasia.public_library_event_source.domain.model.BookAvailabilityStatus.AVAILABLE;
import static com.rcasia.public_library_event_source.domain.model.BookAvailabilityStatus.LENDED;

public class Book{

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("availabilityStatus")
    private BookAvailabilityStatus availabilityStatus = AVAILABLE;

    private List<BookEvent> events;


    public String id(){
        return this.id;
    }

    public List<BookEvent> events(){
        return this.events;
    }

    public Book(BookEvent.BookRegistered bookRegistered) {
        this.events = new ArrayList<>();
        this.apply(bookRegistered);
    }

    public Book(List<BookEvent> bookEvents) {
        this.events = new ArrayList<>();
        bookEvents.stream().forEach(
                this::apply
        );
    }

    public void apply(BookEvent bookEvent) {

        events.add(bookEvent);

        switch (bookEvent) {
            case BookEvent.BookRegistered bookRegistered:
                this.register(bookRegistered);
                break;
            case BookEvent.BookLended bookLended:
                this.lend();
                break;

        }
    }

    private void register(BookEvent.BookRegistered bookRegistered){
        this.id = bookRegistered.bookId();
        this.title = bookRegistered.bookTitle();
    }

    private void lend() {
        this.availabilityStatus = LENDED;
    }
}
