package com.freedom.model;

public enum Molhos {
    ITALIANO(0, "Italiano"),
    APIMENTADO(1, "Apimentado");

    private Integer codigo;
    private String descricao;

    Molhos(Integer codigo, String descricao) {
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
