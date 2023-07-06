package br.com.aw_agencia_digital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indenticando a classe como entidade
@Table(name = "cliente")
public class Cliente {

	@GeneratedValue(strategy = GenerationType.AUTO)// Criando uma sequencia de ID's
	@Id
	@Column(name = "IdCliente")
	private int IdCliente;
	
	@Column(name = "NomeCliente", nullable = false)
	private String nomeCliente;
	
	@Column(name = "CNPJ", nullable = false)
	private String cnpj;
	
	@Column(name = "NumeroContato", nullable = false)
	private String numeroContato;
	
	@Column(name = "QntdLojas", nullable = false)
	private int qntdLojas;
	
	@Column(name = "IdLoja", nullable = false)
	private int IdLoja;
	
	@Column(name = "ValorGestao", nullable = false)
	private double valorGestão;
	
	@Column(name = "DiaPagamento", nullable = false)
	private String diaPagamento;
	
	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNumeroContato() {
		return numeroContato;
	}
	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}
	public int getQntdLojas() {
		return qntdLojas;
	}
	public void setQntdLojas(int qntdLojas) {
		this.qntdLojas = qntdLojas;
	}
	public int getIdLoja() {
		return IdLoja;
	}
	public void setIdLoja(int idLoja) {
		IdLoja = idLoja;
	}
	public double getValorGestão() {
		return valorGestão;
	}
	public void setValorGestão(double valorGestão) {
		this.valorGestão = valorGestão;
	}
	public String getDiaPagamento() {
		return diaPagamento;
	}
	public void setDiaPagamento(String diaPagamento) {
		this.diaPagamento = diaPagamento;
	}
	
	
	
	
}
