package io.github.kkhanhluu.catalogservice.adapter.in.web.create_book;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import io.github.kkhanhluu.catalogservice.application.port.in.CreateBookCommand;
import io.github.kkhanhluu.catalogservice.application.port.in.CreateBookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class CreateBookController {

    private final CreateBookUseCase createBookUseCase;
    private final CreateBookRequestBodyMapper createBookRequestBodyMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody CreateBookRequestBody body) {
        return createBookUseCase.createBook(createBookRequestBodyMapper.mapToCommand(body));
    }
}
