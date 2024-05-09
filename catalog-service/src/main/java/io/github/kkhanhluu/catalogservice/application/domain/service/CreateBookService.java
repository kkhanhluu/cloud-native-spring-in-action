package io.github.kkhanhluu.catalogservice.application.domain.service;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import io.github.kkhanhluu.catalogservice.application.port.in.CreateBookCommand;
import io.github.kkhanhluu.catalogservice.application.port.in.CreateBookUseCase;
import io.github.kkhanhluu.catalogservice.application.port.out.CreateBookPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookService implements CreateBookUseCase {

    private final CreateBookPort createBookPort;

    @Override
    public Book createBook(CreateBookCommand createBookCommand) {
        Book book = new Book(createBookCommand.isbn(), createBookCommand.title(),
            createBookCommand.author(), createBookCommand.price());
        return createBookPort.createBookDetail(book);
    }
}
