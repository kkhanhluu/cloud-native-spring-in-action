package io.github.kkhanhluu.catalogservice.application.port.out;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import java.util.Optional;

public interface LoadBookDetailPort {
    Optional<Book> loadBookByIsbn(String isbn);
}
