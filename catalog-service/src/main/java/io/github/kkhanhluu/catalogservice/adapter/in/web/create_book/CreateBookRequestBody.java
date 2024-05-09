package io.github.kkhanhluu.catalogservice.adapter.in.web.create_book;

import java.math.BigDecimal;

public record CreateBookRequestBody(String isbn, String title, String author, BigDecimal price) {

}
