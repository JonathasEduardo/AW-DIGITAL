package com.awdigital.awDigital.dtos;

import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.models.Loja;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class LojaFindAllDTO implements Serializable {


    private static final long serialVersionUID = 1L;


    private Integer idLoja;


    private String nomeLoja;


    private String numeroLoja;


    private String investimentoLoja;


    private List<Cliente> cliente = new ArrayList<>();

    public LojaFindAllDTO(Integer idLoja, String nomeLoja, String numeroLoja, String investimentoLoja) {
        super();
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
        this.numeroLoja = numeroLoja;
        this.investimentoLoja = investimentoLoja;

    }


    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        idLoja = idLoja;
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

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LojaFindAllDTO loja = (LojaFindAllDTO) o;
        return idLoja == loja.idLoja && Objects.equals(nomeLoja, loja.nomeLoja) && Objects.equals(numeroLoja, loja.numeroLoja) && Objects.equals(investimentoLoja, loja.investimentoLoja) && Objects.equals(cliente, loja.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLoja, nomeLoja, numeroLoja, investimentoLoja, cliente);
    }
}
