package br.com.projeto_andreia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "Usuario")
public class Usuario extends GenericDomain{

	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(length = 50, nullable = false)
	private String email;
	
    ///////////////////////////////////////////////////////////

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}