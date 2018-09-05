package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
        cliente.setNome("Iran Macedo Bezerra Neto");
        cliente.setEndereco("Rua João Alves de Melo, 123");
        cliente.setProfissao("Estudante");
        
        Conta conta = new Conta();
        conta.setId(7);

        cliente.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
	}
}
