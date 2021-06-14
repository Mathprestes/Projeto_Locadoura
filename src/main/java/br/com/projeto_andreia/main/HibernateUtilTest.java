package br.com.projeto_andreia.main;

import org.hibernate.Session;
import br.com.projeto_andreia.util.HibernateUtil;

public class HibernateUtilTest {

	public static void main(String[] args) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();
		
		sessao.close();
		
		HibernateUtil.getFabricaSessoes().close();// destruir a fabrica de sessões
   }
}


