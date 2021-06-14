package br.com.projeto_andreia.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.projeto_andreia.dao.ListFilmeDAO;
import br.com.projeto_andreia.domain.ListFilme;
import br.com.projeto_andreia.util.JsfUtil;

@ManagedBean //ela que vai gerenciar a comunicaçao entre o model e o view
@ViewScoped
public class ListFilmeController {
	
	private List<ListFilme> listFilmes;
	
	private ListFilme listFilme;
	
	private String acao;
	
	///////////////////////////////////
	
	public List<ListFilme> getListFilmes() {
		return listFilmes;
	}

	public void setListFilme(List<ListFilme> listFilmes) {
		this.listFilmes = listFilmes;
	}
	
	public ListFilme getListFilme() {
		if (listFilme == null) {
			listFilme = new ListFilme();
		}
		return listFilme;
	}

	public void setListFilme(ListFilme listFilme) {
		this.listFilme = listFilme;
	}
	
	public String listFilmeController() {
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
				
			ListFilmeDAO dao = new ListFilmeDAO();
			listFilmes = dao.listar();
		} 
			
	catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os Filmes!!!");
			erro.printStackTrace();
		}
	}
	
    public void carregarCadastro() {
		try {
			
			acao = JsfUtil.getParam("foracao");
			
			String valor = JsfUtil.getParam("forcod");
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				ListFilmeDAO listFilmeDAO = new ListFilmeDAO();
				listFilme = listFilmeDAO.buscar(codigo);
			}
			
			else {
				listFilme = new ListFilme();
			}
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError("Ocorreu um erro ao carregar o cadastro");
			  erro.printStackTrace();
		      }	
	}
	
	public void salvar() {
		  
        try {
        	ListFilmeDAO listFilmeDao = new ListFilmeDAO();
        	listFilmeDao.salvar(listFilme);
        	Messages.addGlobalInfo("Filme salvo com sucesso");
		} 
        
        catch (RuntimeException erro) {
        	Messages.addGlobalError("Erro ao adicionar esse Filme!!!");
        	erro.printStackTrace();
		}		
	}
	
	   public void excluir() {
			try {
				
	        	ListFilmeDAO listFilmeDAO = new ListFilmeDAO();
	        	listFilmeDAO.excluir(listFilme);
	        	Messages.addGlobalInfo("Filme excluido com sucesso");
			} 
	        
	        catch (RuntimeException erro) {
	        	Messages.addGlobalError("Erro ao excluir esse Filme!!!");
	        	erro.printStackTrace();
			}	
		}
}