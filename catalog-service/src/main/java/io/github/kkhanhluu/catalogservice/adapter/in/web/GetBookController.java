package io.github.kkhanhluu.catalogservice.adapter.in.web;

import io.github.kkhanhluu.catalogservice.adapter.in.web.exception.BookNotFoundException;
import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import io.github.kkhanhluu.catalogservice.application.port.out.LoadBookDetailPort;
import io.github.kkhanhluu.catalogservice.application.port.out.LoadBookListPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class GetBookController {

    private final LoadBookListPort loadBookListPort;
    private final LoadBookDetailPort loadBookDetailPort;

    @GetMapping
    public List<Book> getListBooks() {
        return loadBookListPort.loadBookList();
    }

    @GetMapping("/{isbn}")
    public Book getBookDetails(@PathVariable("isbn") String isbn) {
        return loadBookDetailPort.loadBookByIsbn(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
    }
}
