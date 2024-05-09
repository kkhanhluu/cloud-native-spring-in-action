package io.github.kkhanhluu.catalogservice.adapter.out.persistence.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String isbn;

    @Column
    private String title;

    @Column
    private BigDecimal price;
}
