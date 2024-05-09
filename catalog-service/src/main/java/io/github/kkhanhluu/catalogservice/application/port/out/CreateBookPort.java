package io.github.kkhanhluu.catalogservice.application.port.out;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;

public interface CreateBookPort {

    Book createBookDetail(Book book);
}
