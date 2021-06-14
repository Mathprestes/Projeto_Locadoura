package br.com.projeto_andreia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "ListFilme")
public class ListFilme extends GenericDomain{

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String nomefilme;
	
	@Column(length = 20, nullable = false)
	private String duracao;
	
	@Column
	private String clas;
	
	@Column
	private String tipos;
	
	@Column(length = 8, nullable = false)
	private Double valor;
	
    ///////////////////////////////////////

	public String getNomefilme() {
		return nomefilme;
	}

	public void setNomefilme(String nomefilme) {
		this.nomefilme = nomefilme;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

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
}