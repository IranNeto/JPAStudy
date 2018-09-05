package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Conta conta = em.find(Conta.class, 7);
		conta.setId(1);
//		em.remove(conta);
//		conta = em.find(Conta.class, 8);
		
		System.out.println(conta.getTitular());
		em.getTransaction().commit();
	}
}
