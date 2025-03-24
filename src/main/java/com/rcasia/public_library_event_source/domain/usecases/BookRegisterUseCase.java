package com.rcasia.public_library_event_source.domain.usecases;

import com.rcasia.public_library_event_source.domain.commands.RegisterBookCommand;
import com.rcasia.public_library_event_source.domain.model.Book;

public interface BookRegisterUseCase {
    Book registerBook(RegisterBookCommand command);
}
