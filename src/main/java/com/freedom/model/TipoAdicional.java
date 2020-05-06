package com.freedom.model;

public enum TipoAdicional {
	TIPO_QUEIJO(0, "Queijo"),
	TIPO_PAO(1, "Tipo de Pão"),
	TIPO_RECHEIO(2, "Recheio");

    private Integer codigo;
    private String descricao;

    TipoAdicional(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }
    
    public static TipoAdicional valueOfCodigo(Integer codigo) {
    	for(TipoAdicional t : TipoAdicional.values()) {
    		if(t.getCodigo().equals(codigo))
    			return t;
    	}
    	
    	return null;
    }

}
