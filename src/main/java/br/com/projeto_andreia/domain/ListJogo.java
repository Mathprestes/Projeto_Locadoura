package br.com.projeto_andreia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "ListJogo")
public class ListJogo extends GenericDomain{

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String nomejogo;
	
	@Column
	private String tipos;
	
	@Column(length = 8, nullable = false)
	private Double valor;
	
    ///////////////////////////////////////
	
	public String getTipos() {
		return tipos;
	}
	
	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNomejogo() {
		return nomejogo;
	}

	public void setNomejogo(String nomejogo) {
		this.nomejogo = nomejogo;
	}
}