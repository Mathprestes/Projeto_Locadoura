package br.com.projeto_andreia.util;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

//String para busca de parametros atraves do mapeamento
public class JsfUtil {
	
	public static String getParam(String nome) {
		
		FacesContext contextoContext = FacesContext.getCurrentInstance(); //pegar contexto a informaçao que esta sendo buscada
		
		ExternalContext externalContext = contextoContext.getExternalContext();  //tipo mapeamento
		
		Map<String, String> parametros = externalContext.getRequestParameterMap();   //criaçao do mapeamento
		
		String valor = parametros.get(nome);  //apontamento do mapa para a variavel parametros
		
		return valor;
	}
}