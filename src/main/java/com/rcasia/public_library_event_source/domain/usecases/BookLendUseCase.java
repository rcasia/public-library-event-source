package com.rcasia.public_library_event_source.domain.usecases;

import com.rcasia.public_library_event_source.domain.commands.LendBookCommand;

public interface BookLendUseCase {
    void lendBook(LendBookCommand command);
}
