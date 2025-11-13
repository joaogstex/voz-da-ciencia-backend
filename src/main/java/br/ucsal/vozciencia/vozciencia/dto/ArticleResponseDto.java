package br.ucsal.vozciencia.vozciencia.dto;

import br.ucsal.vozciencia.vozciencia.model.Article;
import lombok.Data;

@Data
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String categoryName;
    private String sourceUrl;
    private String text; 

    public static ArticleResponseDto fromEntity(Article article) {
        ArticleResponseDto dto = new ArticleResponseDto();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setCategoryName(article.getCategory().getName());
        dto.setSourceUrl(article.getSourceUrl());
        dto.setText(article.getText()); 
        return dto;
    }
}