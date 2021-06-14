package br.com.projeto_andreia.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.projeto_andreia.dao.ListJogoDAO;
import br.com.projeto_andreia.domain.ListJogo;
import br.com.projeto_andreia.util.JsfUtil;

@ManagedBean //ela que vai gerenciar a comunicaçao entre o model e o view
@ViewScoped
public class ListJogoController {
	
	private List<ListJogo> listJogos;
	
	private ListJogo listJogo;
	
	private String acao;
	
	///////////////////////////////////
	
	public List<ListJogo> getListJogos() {
		return listJogos;
	}

	public void setListJogo(List<ListJogo> listJogos) {
		this.listJogos = listJogos;
	}
	
	public ListJogo getListJogo() {
		if (listJogo == null) {
			listJogo = new ListJogo();
		}
		return listJogo;
	}

	public void setListJogo(ListJogo listJogo) {
		this.listJogo = listJogo;
	}
	
	public String listJogoController() {
		return acao;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	///////////////////////////////////////
	
	@PostConstruct
	public void listar() {
		try {
				
			ListJogoDAO dao = new ListJogoDAO();
			listJogos = dao.listar();
		} 
			
	catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os Jogos!!!");
			erro.printStackTrace();
		}
	}
	
    public void carregarCadastro() {
		try {
			
			acao = JsfUtil.getParam("foracao");
			
			String valor = JsfUtil.getParam("forcod");
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				ListJogoDAO listJogoDAO = new ListJogoDAO();
				listJogo = listJogoDAO.buscar(codigo);
			}
			
			else {
				listJogo = new ListJogo();
			}
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError("Ocorreu um erro ao carregar o cadastro");
			  erro.printStackTrace();
		      }	
	}
	
	public void salvar() {
		  
        try {
        	ListJogoDAO listJogoDao = new ListJogoDAO();
        	listJogoDao.salvar(listJogo);
        	Messages.addGlobalInfo("Jogo salvo com sucesso");
		} 
        
        catch (RuntimeException erro) {
        	Messages.addGlobalError("Erro ao adicionar esse Jogo!!!");
        	erro.printStackTrace();
		}		
	}
	
	   public void excluir() {
			try {
				
	        	ListJogoDAO listJogoDAO = new ListJogoDAO();
	        	listJogoDAO.excluir(listJogo);
	        	Messages.addGlobalInfo("Jogo excluido com sucesso");
			} 
	        
	        catch (RuntimeException erro) {
	        	Messages.addGlobalError("Erro ao excluir esse Jogo!!!");
	        	erro.printStackTrace();
			}	
		}
}