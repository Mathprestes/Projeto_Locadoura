package br.com.projeto_andreia.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.projeto_andreia.dao.UsuarioDAO;
import br.com.projeto_andreia.domain.Usuario;
import br.com.projeto_andreia.util.JsfUtil;

@ManagedBean
@ViewScoped
public class UsuarioController {
	
    private List<Usuario> usuarios;
	
	private  Usuario usuario;
	
    private String acao;
    
    //////////////////////////////////

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String usuarioController() {
		return acao;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

    /////////////////////////////////////////
	
	@PostConstruct
	public void listar() {
		try {
				
			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar();
		} 
			
	catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao listar os Usuarios!!!");
			erro.printStackTrace();
		}
	}
	
    public void carregarCadastro() {
		try {
			
			acao = JsfUtil.getParam("foracao");
			
			String valor = JsfUtil.getParam("forcod");
			
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuario = usuarioDAO.buscar(codigo);
			}
			
			else {
				usuario = new Usuario();
			}
		} 
		
		catch (RuntimeException erro) {
			  Messages.addGlobalError("Ocorreu um erro ao carregar o cadastro");
			  erro.printStackTrace();
		      }	
	}
    
    public void salvar() { 
	    try {
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        usuarioDAO.salvar(usuario);
	        Messages.addGlobalInfo("Usuario salvo com sucesso");
		} 
	        
	    catch (RuntimeException erro) {
	        Messages.addGlobalError("Erro ao adicionar esse Usuario!!!");
	        erro.printStackTrace();
		}		
	}
    
   public void excluir() {
		try {
			
        	UsuarioDAO usuarioDAO = new UsuarioDAO();
        	usuarioDAO.excluir(usuario);
        	Messages.addGlobalInfo("Usuario excluido com sucesso");
		} 
        
        catch (RuntimeException erro) {
        	Messages.addGlobalError("Erro ao excluir esse Usuario!!!");
        	erro.printStackTrace();
		}	
	}
   
	public void editar() {
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
        	usuarioDAO.editar(usuario);
        	Messages.addGlobalInfo("Usuario atualizado com sucesso");
		} 
        
        catch (RuntimeException erro) {
        	Messages.addGlobalError("Erro em autualizar esse Usuario!!!");
        	erro.printStackTrace();
		}
	}
}