package br.ucsal.vozciencia.vozciencia.service;

import br.ucsal.vozciencia.vozciencia.dto.CuratorRequestDto;
import br.ucsal.vozciencia.vozciencia.model.Article;
import br.ucsal.vozciencia.vozciencia.model.Category;
import br.ucsal.vozciencia.vozciencia.repository.ArticleRepository;
import br.ucsal.vozciencia.vozciencia.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuratorService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Article prepareDailyArticle(CuratorRequestDto request) {
        
        Category category = categoryRepository.findByName(request.getCategoryName())
                .orElseGet(() -> categoryRepository.save(new Category(request.getCategoryName())));

        articleRepository.deleteAllByCategoryName(category.getName());
        System.out.println("LOG: [CuratorService] Artigos antigos da categoria '" + category.getName() + "' removidos.");

        Article article = new Article(
            request.getTitle(),
            category,
            request.getSourceUrl(),
            request.getDoi(),
            request.getText()
        );
        
        article.setProcessed(true); 

        Article savedArticle = articleRepository.save(article);
        System.out.println("LOG: [CuratorService] Novo artigo (ID: " + savedArticle.getId() + ") salvo e publicado.");

        return savedArticle;
    }
}