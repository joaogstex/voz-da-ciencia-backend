package br.ucsal.vozciencia.vozciencia.dto;

import lombok.Data;

@Data
public class CuratorRequestDto {
    private String categoryName;
    private String title;
    private String sourceUrl;
    private String doi;
    private String text; 
}