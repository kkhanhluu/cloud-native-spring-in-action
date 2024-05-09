package io.github.kkhanhluu.catalogservice.application.port.in;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import java.util.Optional;

public interface GetBookDetailsUseCase {

    Optional<Book> getBookDetails(GetBookDetailQuery query);

    record GetBookDetailQuery(String isbn) {

    }
}
