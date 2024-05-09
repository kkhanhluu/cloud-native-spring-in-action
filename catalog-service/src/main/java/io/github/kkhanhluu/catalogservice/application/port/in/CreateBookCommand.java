package io.github.kkhanhluu.catalogservice.application.port.in;

import static io.github.kkhanhluu.catalogservice.common.Validation.validate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record CreateBookCommand(
    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$", message = "The ISBN format must be valid.")
    String isbn,
    @NotBlank(message = "The book title must be defined.")
    String title,
    @NotBlank(message = "The book author must be defined.")
    String author,
    @NotNull(message = "The book price must be defined.")
    @Positive(message = "The book price must be greater than zero.")
    BigDecimal price) {

    public CreateBookCommand(String isbn, String title, String author, BigDecimal price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        validate(this);
    }
}
