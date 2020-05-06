package com.freedom.model;

public enum Genero {
    MASCULINO(0, "Masculino", "Masc"),
    FIMININO(1, "Feminino", "Fem");

    private Integer codigo;
    private String descricao;
    private String abreviacao;

    Genero(Integer codigo, String descricao, String abreviacao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.abreviacao = abreviacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public Integer getCodigo() {
        return codigo;
    }


}
