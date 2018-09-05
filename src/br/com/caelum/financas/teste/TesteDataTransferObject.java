package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.ContaComNumeroEAgencia;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteDataTransferObject {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
		List<ContaComNumeroEAgencia> contas = em.createQuery("select new br.com.caelum.financas.modelo.ContaComNomeEAgencia(c.numero, c.agencia) from Conta c", ContaComNumeroEAgencia.class).getResultList();
		for (ContaComNumeroEAgencia ccan : contas) {
	        System.out.println("ccan agencia: " + ccan.getAgencia());
	        System.out.println("ccan numero " + ccan.getNumeroConta());
	        System.out.println("object: " + ccan.toString());
	    } 

	    em.getTransaction().commit();
	    em.close();
	}
}
