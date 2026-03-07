package com.ronaldo.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoBusca {

    private List<DadosLivro> results;

    public List<DadosLivro> getResults() {
        return results;
    }
}