package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //Indicação para o Hibernate persistir no banco, criar uma entidade no banco
public class Conta {
	
	//@Id - Indicação que é uma chave primária - @GeneratedValue - Indicação de gerenciamento de Id 
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Auto-increment
	private Integer id;
	private String Titular;
	private String numero;
	private String banco;
	private String agencia;
	
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public String getTitular() {
		return Titular;
	}
	public void setTitular(String titular) {
		Titular = titular;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

}
