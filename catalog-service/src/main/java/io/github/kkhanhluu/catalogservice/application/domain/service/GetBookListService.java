package io.github.kkhanhluu.catalogservice.application.domain.service;

import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import io.github.kkhanhluu.catalogservice.application.port.in.GetBookListUseCase;
import io.github.kkhanhluu.catalogservice.application.port.out.LoadBookListPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBookListService implements GetBookListUseCase {

    private final LoadBookListPort loadBookListPort;

    @Override
    public List<Book> getBookList() {
        return loadBookListPort.loadBookList();
    }

}
