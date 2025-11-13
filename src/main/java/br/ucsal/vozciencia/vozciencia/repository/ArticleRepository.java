package br.ucsal.vozciencia.vozciencia.repository;

import br.ucsal.vozciencia.vozciencia.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findFirstByCategoryNameAndProcessedTrueOrderByIdDesc(String categoryName);
    void deleteAllByCategoryName(String categoryName);
}
