package io.github.kkhanhluu.catalogservice.adapter.in.web.create_book;

import io.github.kkhanhluu.catalogservice.application.port.in.CreateBookCommand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CreateBookRequestBodyMapper {

    CreateBookCommand mapToCommand(CreateBookRequestBody createBookRequestBody);
}
