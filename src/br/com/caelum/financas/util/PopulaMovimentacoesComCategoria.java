package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaMovimentacoesComCategoria {

	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Conta conta = new Conta();
        conta.setId(2); 

        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance()); // hoje
        movimentacao1.setDescricao("Viagem à SP");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao1.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        Calendar amnh = Calendar.getInstance();
        amnh.add(Calendar.DAY_OF_MONTH, 1);
        
        movimentacao2.setData(amnh); // amnh
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao2.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(categoria1); // Agora a 'categoria1' é Managed
        em.persist(categoria2); // Agora a 'categoria2' é Managed

        em.persist(movimentacao1);
        em.persist(movimentacao2);

        em.getTransaction().commit();    
        em.close();

	}

}
