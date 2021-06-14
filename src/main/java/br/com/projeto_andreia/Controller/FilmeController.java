package br.com.projeto_andreia.Controller;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.projeto_andreia.dao.FilmeDAO;
import br.com.projeto_andreia.domain.Filme;

import br.com.projeto_andreia.dao.ListFilmeDAO;
import br.com.projeto_andreia.domain.ListFilme;

import br.com.projeto_andreia.dao.UsuarioDAO;
import br.com.projeto_andreia.domain.Usuario;

@ManagedBean
@ViewScoped
public class FilmeController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Filme> filmes;
	
	private Filme filme;
	
	private List<ListFilme> listFilmes; //chave estrangeira
	
	private List<Usuario> usuarios; //chave estrangeira
	
	////////////////////////////////

	public List<Filme> getFilmes() {
		return filmes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<ListFilme> getListFilmes() {
		return listFilmes;
	}

	public void setListFilmes(List<ListFilme> listFilmes) {
		this.listFilmes = listFilmes;
	}
	
	////////////////////////////////////////////
	
	//a hora q ele construir o fomulario ele executa esse metodo(na hr da pagina abrir)
	@PostConstruct
	public void listar() {
		try {
			
			FilmeDAO dao = new FilmeDAO();
			filmes = dao.listar();
		
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError ("Erro ao carregar as informações!!!");
			  erro.printStackTrace();
			
		}
	}

	public void novo() {
        try {
			
			filme = new Filme();
			
			ListFilmeDAO dao = new ListFilmeDAO();
			listFilmes = dao.listar();
			
			UsuarioDAO dao2 = new UsuarioDAO();
			usuarios = dao2.listar();
			
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError ("Erro ao carregar as informações!!!");
			  erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			
			FilmeDAO dao = new FilmeDAO();
			dao.merge(filme);
			novo();
			
			filmes = dao.listar();
			
			Messages.addGlobalInfo("Aluguel de Filmes Salvo com sucesso");
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError ("Erro ao salvar!!!");
			  erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			filme = (Filme) evento.getComponent().getAttributes().get("produtoSelecionado");

			FilmeDAO dao = new FilmeDAO();
			dao.excluir(filme);

			filmes = dao.listar();

			Messages.addGlobalInfo("Filme removido com sucesso");
		
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover esse aluguel");
			erro.printStackTrace();
		}
	}
}