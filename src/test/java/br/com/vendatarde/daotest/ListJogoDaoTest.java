package br.com.vendatarde.daotest;

import org.junit.Test;

import br.com.projeto_andreia.dao.ListJogoDAO;
import br.com.projeto_andreia.domain.ListJogo;

public class ListJogoDaoTest {

	@Test
	public void salvar() {

		ListJogo listJogo = new ListJogo();

		listJogo.setNomejogo ("Maridsrfgaa");

		ListJogoDAO dao = new ListJogoDAO();
		dao.salvar(listJogo);

		System.out.println("Jogo Salvo com Sucesso!!!");

	}
}
