package io.github.kkhanhluu.catalogservice.application.port.in;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;

public interface CreateBookUseCase {

    Book createBook(CreateBookCommand createBookCommand);
}
