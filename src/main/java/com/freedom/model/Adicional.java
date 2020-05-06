package com.freedom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_adicional")
public class Adicional implements Serializable {

	private static final long serialVersionUID = -5446115930564539620L;

	@Id
	@Column(name="id_adicional")
	@SequenceGenerator(name = "tb_usuario_gen", sequenceName = "tb_usuario_id_adicional_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_gen")
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	private TipoAdicional tipo;
	
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adicional other = (Adicional) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public TipoAdicional getTipo() {
		return tipo;
	}

	public void setTipo(TipoAdicional tipo) {
		this.tipo = tipo;
	}

}
