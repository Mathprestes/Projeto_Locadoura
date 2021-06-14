package br.com.projeto_andreia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.projeto_andreia.util.HibernateUtil;

public class GenericDao <Entidade> {
	
	private Class<Entidade> classe;
	
	public GenericDao() {
		this.classe = (Class<Entidade>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(Entidade entidade) {	
		Session sessão = HibernateUtil.getFabricaSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessão.beginTransaction();
			sessão.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if(transacao != null)
				transacao.rollback();
			throw erro;
		} finally {
			sessão.close();
		}
	}
	
	public List<Entidade> listar() {
		Session sessão = HibernateUtil.getFabricaSessoes().openSession();
		try {
			Criteria consulta = sessão.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessão.close();
		}
	}
	
	public Entidade buscar(long codigo) {
		Session sessão = HibernateUtil.getFabricaSessoes().openSession();
		try {
			Criteria consulta = sessão.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade)consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessão.close();
		}
	}
	
	public void excluir(Entidade entidade) {	
		Session sessão = HibernateUtil.getFabricaSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessão.beginTransaction();
			sessão.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if(transacao != null)
				transacao.rollback();
			throw erro;
		} finally {
			sessão.close();
		}
	}
	
	public void editar(Entidade entidade) {	
		Session sessão = HibernateUtil.getFabricaSessoes().openSession();
		Transaction transacao = null;
		try {
			transacao = sessão.beginTransaction();
			sessão.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if(transacao != null)
				transacao.rollback();
			throw erro;
		} finally {
			sessão.close();
		}
	}
	
	public void merge(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();

			sessao.merge(entidade);

			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();

			}
			throw erro;

		} finally {
			sessao.close();
		}
	}
}