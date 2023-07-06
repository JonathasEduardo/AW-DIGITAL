package br.com.aw_agencia_digital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lojas")
public class Lojas {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "IdLoja")
	private int IdLoja;
	
	@Column(name = "NomeLoja", nullable = false)
	private String nomeLoja;
	
	@Column(name = "numeroLoja", nullable = false)
	private String numeroLoja;
	
	@Column(name = "InvestimentoLoja", nullable = false)
	private double investimentoLoja;
	
	
	public int getIdLoja() {
		return IdLoja;
	}
	public void setIdLoja(int idLoja) {
		IdLoja = idLoja;
	}
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public String getNumeroLoja() {
		return numeroLoja;
	}
	public void setNumeroLoja(String numeroLoja) {
		this.numeroLoja = numeroLoja;
	}
	public double getInvestimentoLoja() {
		return investimentoLoja;
	}
	public void setInvestimentoLoja(double investimentoLoja) {
		this.investimentoLoja = investimentoLoja;
	}
	
	
	
}
