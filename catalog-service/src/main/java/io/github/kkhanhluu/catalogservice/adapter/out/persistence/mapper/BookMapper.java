package io.github.kkhanhluu.catalogservice.adapter.out.persistence.mapper;

import io.github.kkhanhluu.catalogservice.adapter.out.persistence.entity.BookJpaEntity;
import io.github.kkhanhluu.catalogservice.application.domain.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BookMapper {
    Book mapFromEntity(BookJpaEntity bookJpaEntity);
    BookJpaEntity fromDomain(Book book);
}
