package com.awdigital.awDigital.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Loja implements Serializable {


    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idLoja;


    private String nomeLoja;


    private String numeroLoja;


    private String investimentoLoja;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Loja(Integer idLoja, String nomeLoja, String numeroLoja, String investimentoLoja, Cliente cliente) {
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
        this.numeroLoja = numeroLoja;
        this.investimentoLoja = investimentoLoja;
        this.cliente = cliente;
    }

    public Loja() {
    }

    public Integer getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Integer idLoja) {
        this.idLoja = idLoja;
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

    public String getInvestimentoLoja() {
        return investimentoLoja;
    }

    public void setInvestimentoLoja(String investimentoLoja) {
        this.investimentoLoja = investimentoLoja;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return idLoja == loja.idLoja && Objects.equals(nomeLoja, loja.nomeLoja) && Objects.equals(numeroLoja, loja.numeroLoja) && Objects.equals(investimentoLoja, loja.investimentoLoja) && Objects.equals(cliente, loja.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLoja, nomeLoja, numeroLoja, investimentoLoja, cliente);
    }

}
