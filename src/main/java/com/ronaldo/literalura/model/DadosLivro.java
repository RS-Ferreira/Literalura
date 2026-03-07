package com.ronaldo.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosLivro {

    private String title;
    private List<DadosAutor> authors;
    private List<String> languages;
    private Double download_count;

    public String getTitle() {
        return title;
    }

    public List<DadosAutor> getAuthors() {
        return authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Double getDownload_count() {
        return download_count;
    }
}