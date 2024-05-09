package io.github.kkhanhluu.catalogservice.application.domain.service;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import io.github.kkhanhluu.catalogservice.application.port.in.GetBookDetailsUseCase;
import io.github.kkhanhluu.catalogservice.application.port.out.LoadBookDetailPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBookDetailsService implements GetBookDetailsUseCase {

    private final LoadBookDetailPort loadBookDetailPort;

    @Override
    public Optional<Book> getBookDetails(GetBookDetailQuery query) {
        return loadBookDetailPort.loadBookByIsbn(query.isbn());
    }
}
