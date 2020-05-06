package com.freedom.model;

public enum Temperos {
    PIMENTA(0, "Pimenta"),
    SAL(1, "Sal"),
    OREGANO(2, "Oregano");

    private Integer codigo;
    private String descricao;

    Temperos(Integer codigo, String descricao) {
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
