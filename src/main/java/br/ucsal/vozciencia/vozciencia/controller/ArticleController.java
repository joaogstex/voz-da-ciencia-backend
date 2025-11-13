package br.ucsal.vozciencia.vozciencia.controller;

import br.ucsal.vozciencia.vozciencia.dto.ArticleResponseDto;
import br.ucsal.vozciencia.vozciencia.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/daily")
    public ResponseEntity<ArticleResponseDto> getDailyArticle(
            @RequestParam("category") String categoryName) {
        
        return articleService.getDailyArticleByCategory(categoryName)
                .map(ResponseEntity::ok) 
                .orElse(ResponseEntity.notFound().build()); 
    }
}