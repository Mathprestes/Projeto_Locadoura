package br.com.vendatarde.daotest;

import org.junit.Test;

import br.com.projeto_andreia.dao.UsuarioDAO;
import br.com.projeto_andreia.domain.Usuario;

public class UsuarioDaoTest {

	@Test
	public void salvar() {

		Usuario usuario = new Usuario();

		usuario.setNome     ("Maridsrfgaa");
		usuario.setCpf      ("Maridsrfgaa");
		usuario.setTelefone ("Maridsrfgaa");
		usuario.setEmail    ("Maridsrfgaa");

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);

		System.out.println("Usuario Salvo com Sucesso!!!");

	}
}
