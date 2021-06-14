package br.com.projeto_andreia.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "AlocFilme")
public class Filme extends GenericDomain{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private ListFilme listfilme;
	
	@Column(nullable = false)
	private Date date1;
	
	@Column(nullable = false)
	private Date date2;
	
	@Column
	private String metodo;
	
    /////////////////////////////////////////////////

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ListFilme getListfilme() {
		return listfilme;
	}

	public void setListfilme(ListFilme listfilme) {
		this.listfilme = listfilme;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
}