package com.freedom.model;

public enum Saladas {
    ALFACE(0, "Alface"),
    RUCULA(1, "Rúcula"),
    ACELGA(2, "Acelga");

    private Integer codigo;
    private String descricao;

    Saladas(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

}
