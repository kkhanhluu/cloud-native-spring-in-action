package io.github.kkhanhluu.catalogservice.application.port.in;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;

public interface GetBookListUseCase {

    Iterable<Book> getBookList();
}
