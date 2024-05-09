package io.github.kkhanhluu.catalogservice.application.domain.model;

import java.math.BigDecimal;

public record Book(String isbn, String title, String author, BigDecimal price) {

}