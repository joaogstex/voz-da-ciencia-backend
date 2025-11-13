package br.ucsal.vozciencia.vozciencia.controller;

import br.ucsal.vozciencia.vozciencia.dto.ArticleResponseDto;
import br.ucsal.vozciencia.vozciencia.dto.CuratorRequestDto;
import br.ucsal.vozciencia.vozciencia.model.Article;
import br.ucsal.vozciencia.vozciencia.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curator")
public class CuratorController {

    @Autowired
    private CuratorService curatorService;

    @PostMapping("/publish")
    public ResponseEntity<ArticleResponseDto> publishDailyArticle(
            @RequestBody CuratorRequestDto request) {
        
        Article article = curatorService.prepareDailyArticle(request);
        return ResponseEntity.ok(ArticleResponseDto.fromEntity(article));
    }
}