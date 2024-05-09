package io.github.kkhanhluu.catalogservice.adapter.out.persistence.repository;


import io.github.kkhanhluu.catalogservice.adapter.out.persistence.entity.BookJpaEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<BookJpaEntity, Long> {

    @Query("SELECT b FROM BookJpaEntity b WHERE b.isbn = :isbn")
    Optional<BookJpaEntity> findByIsbn(@Param("isbn") String isbn);

    @Query("DELETE FROM BookJpaEntity b WHERE b.isbn = :isbn")
    void deleteBookByIsbn(@Param("isbn") String isbn);
}
