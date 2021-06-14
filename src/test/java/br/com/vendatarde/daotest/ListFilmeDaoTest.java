package br.com.vendatarde.daotest;

import org.junit.Test;

import br.com.projeto_andreia.dao.ListFilmeDAO;
import br.com.projeto_andreia.domain.ListFilme;


public class ListFilmeDaoTest {

	@Test
	public void salvar() {

		ListFilme listFilme = new ListFilme();

		listFilme.setNomefilme ("Maridsrfgaa");
		listFilme.setClas ("Maridsrfgaa");
		listFilme.setDuracao ("44");
		listFilme.setValor (44.5);

		ListFilmeDAO dao = new ListFilmeDAO();
		dao.salvar(listFilme);

		System.out.println("Filme Salvo com Sucesso!!!");

	}
}