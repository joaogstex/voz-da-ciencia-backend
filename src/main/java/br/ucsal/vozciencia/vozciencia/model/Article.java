package br.ucsal.vozciencia.vozciencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String sourceUrl;
    
    private String doi;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String text; 

    private boolean processed = false; 
    
    public Article(String title, Category category, String sourceUrl, String doi, String text) {
        this.title = title;
        this.category = category;
        this.sourceUrl = sourceUrl;
        this.doi = doi;
        this.text = text;
        this.processed = false;
    }
}