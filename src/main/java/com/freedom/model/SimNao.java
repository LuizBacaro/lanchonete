package com.freedom.model;

public enum SimNao {
    SIM(0, "Sim"),
    NAO(1, "Não");

    private Integer codigo;
    private String descricao;

    SimNao(Integer codigo, String descricao) {
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
