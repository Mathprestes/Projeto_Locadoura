package br.com.projeto_andreia.Controller;

import java.io.Serializable;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.projeto_andreia.dao.JogoDAO;
import br.com.projeto_andreia.domain.Jogo;

import br.com.projeto_andreia.dao.ListJogoDAO;
import br.com.projeto_andreia.domain.ListJogo;

import br.com.projeto_andreia.domain.Usuario;
import br.com.projeto_andreia.dao.UsuarioDAO;

@ManagedBean
@ViewScoped
public class JogoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Jogo> jogos;
	
	private Jogo jogo;
	
	private List<ListJogo> listJogos;
	
	private List<Usuario> usuarios;
	
	///////////////////////////////

	public List<Jogo> getJogos() {
		return jogos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<ListJogo> getListJogos() {
		return listJogos;
	}

	public void setListJogos(List<ListJogo> listJogos) {
		this.listJogos = listJogos;
	}
	
	//////////////////////////////////////////////
	
    //a hora q ele construir o fomulario ele executa esse metodo(na hr da pagina abrir)
	@PostConstruct
	public void listar() {
		try {
			
			JogoDAO dao = new JogoDAO();
			jogos = dao.listar();
			
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError ("Erro ao carregar as informações!!!");
			  erro.printStackTrace();
			
		}
	}

	public void novo() {
        try {
			
			jogo = new Jogo();
			
			ListJogoDAO dao = new ListJogoDAO();
			listJogos = dao.listar();
			
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
			
			JogoDAO dao = new JogoDAO();
			dao.merge(jogo);
			novo();
			
			jogos = dao.listar();
			
			Messages.addGlobalInfo("Aluguel de Jogos Salvo com sucesso");
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError ("Erro ao salvar!!!");
			  erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			jogo = (Jogo) evento.getComponent().getAttributes().get("produtoSelecionado");

			JogoDAO dao = new JogoDAO();
			dao.excluir(jogo);

			jogos = dao.listar();

			Messages.addGlobalInfo("Jogo removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover esse aluguel");
			erro.printStackTrace();
		}
	}
}