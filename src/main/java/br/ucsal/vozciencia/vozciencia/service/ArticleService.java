package br.ucsal.vozciencia.vozciencia.service;

import br.ucsal.vozciencia.vozciencia.dto.ArticleResponseDto;
import br.ucsal.vozciencia.vozciencia.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<ArticleResponseDto> getDailyArticleByCategory(String categoryName) {
        System.out.println("LOG: [ArticleService] Buscando artigo do dia para categoria: " + categoryName);
        
        return articleRepository.findFirstByCategoryNameAndProcessedTrueOrderByIdDesc(categoryName)
                .map(ArticleResponseDto::fromEntity); 
    }
}