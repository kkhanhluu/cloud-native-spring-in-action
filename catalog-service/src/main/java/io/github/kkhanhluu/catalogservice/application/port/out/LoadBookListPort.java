package io.github.kkhanhluu.catalogservice.application.port.out;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import java.util.List;

public interface LoadBookListPort {
    List<Book> loadBookList();
}
