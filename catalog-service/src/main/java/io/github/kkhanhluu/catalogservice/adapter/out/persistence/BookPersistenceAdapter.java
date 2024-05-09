package io.github.kkhanhluu.catalogservice.adapter.out.persistence;

import io.github.kkhanhluu.catalogservice.adapter.out.persistence.entity.BookJpaEntity;
import io.github.kkhanhluu.catalogservice.adapter.out.persistence.mapper.BookMapper;
import io.github.kkhanhluu.catalogservice.adapter.out.persistence.repository.BookRepository;
import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import io.github.kkhanhluu.catalogservice.application.port.out.CreateBookPort;
import io.github.kkhanhluu.catalogservice.application.port.out.EditBookDetailsPort;
import io.github.kkhanhluu.catalogservice.application.port.out.LoadBookDetailPort;
import io.github.kkhanhluu.catalogservice.application.port.out.LoadBookListPort;
import io.github.kkhanhluu.catalogservice.application.port.out.RemoveBookPort;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookPersistenceAdapter implements LoadBookListPort, LoadBookDetailPort, RemoveBookPort,
    EditBookDetailsPort, CreateBookPort {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<Book> loadBookList() {
        return bookRepository.findAll().stream().map(bookMapper::mapFromEntity).toList();
    }

    @Override
    public Optional<Book> loadBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).map(bookMapper::mapFromEntity);
    }

    @Override
    public void removeBook(RemoveBookCommand command) {
        bookRepository.deleteBookByIsbn(command.isbn());
    }

    @Override
    public Book editBookDetails(Book newBookDetails) {
        return bookRepository.findByIsbn(newBookDetails.isbn()).map(bookJpaEntity -> {
            BookJpaEntity updatedBookEntity = bookMapper.fromDomain(newBookDetails);
            bookRepository.save(updatedBookEntity);
            return bookMapper.mapFromEntity(updatedBookEntity);
        }).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book createBookDetail(Book book) {
        BookJpaEntity savedBook = bookRepository.save(bookMapper.fromDomain(book));
        return bookMapper.mapFromEntity(savedBook);
    }
}
