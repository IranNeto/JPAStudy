package br.com.caelum.financas.teste;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	public static void main(String[] args) {
		Conta c = new Conta();
        c.setTitular("Iran Macedo Bezerra Neto");
        c.setBanco("Caixa Economica");
        c.setAgencia("999");
        c.setNumero("000");
		
        EntityManager em = new JPAUtil().getEntityManager();

        try {
        	em.find(Conta.class, 1);
	        em.getTransaction().begin();
	        em.persist(c);
	        em.getTransaction().commit();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        } finally {
			em.close();
		}

        
	}
}
