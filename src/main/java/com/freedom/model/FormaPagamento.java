package com.freedom.model;

public enum FormaPagamento {
    CREDITO(0, "Crédito"),
    DEBITO(1, "Débito"),
    DINHEIRO(2, "Dinheiro");

    private Integer codigo;
    private String descricao;

    FormaPagamento(Integer codigo, String descricao) {
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
