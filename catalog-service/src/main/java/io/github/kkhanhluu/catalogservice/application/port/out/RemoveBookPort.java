package io.github.kkhanhluu.catalogservice.application.port.out;

public interface RemoveBookPort {

    void removeBook(RemoveBookCommand command);

    record RemoveBookCommand(String isbn) {

    }
}
