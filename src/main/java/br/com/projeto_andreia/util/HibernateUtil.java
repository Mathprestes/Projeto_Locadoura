package br.com.projeto_andreia.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    //fabrica de sessao, classe responsavel por abrir e fechar a porta do banco 
	//pela solicitaçao do Usuario  
	
	private static SessionFactory fabricaSessoes = CriarFabricaSessoes();
	
	public static SessionFactory getFabricaSessoes() {
		return fabricaSessoes;
	}
	
	private static SessionFactory CriarFabricaSessoes() {
		//tratamento de sessao
		try {     //try = tenta isso...
			   
			Configuration configuracao = new Configuration().configure();   //le as configuraçoes dop hibernate
			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();   //registrando o servico e as configuraçoes
			
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);     //criando a fabrica
			
			return fabrica;
			
		} catch (Throwable ex) {
			
			System.err.println (" A Fabrica de Sessoes nao pode ser criada");
			throw new ExceptionInInitializerError(ex);
		}
		
	}
}
