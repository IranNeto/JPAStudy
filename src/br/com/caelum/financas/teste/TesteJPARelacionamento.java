package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		Conta c = new Conta();
	    c.setId(10);
	    Movimentacao movimentacao = new Movimentacao();
	    movimentacao.setData(Calendar.getInstance());
	    movimentacao.setDescricao("Churrascaria");
	    movimentacao.setTipo(TipoMovimentacao.SAIDA);
	    movimentacao.setValor(new BigDecimal("200.0"));
	    
	    movimentacao.setConta(c);

	    EntityManager em = new JPAUtil().getEntityManager();
	    em.getTransaction().begin();
	    em.merge(c);
	    em.persist(movimentacao);

	    em.getTransaction().commit();
	    em.close();
	}
}
