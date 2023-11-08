package com.awdigital.awDigital.dtos;

import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.models.Loja;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class LojaDTO implements Serializable {


    private static final long serialVersionUID = 1L;


    @JsonIgnore
    private Integer idLoja;

    @NotBlank(message = "O campo Nome é obrigatorio")
    private String nomeLoja;

    @NotBlank(message = "O campo NUMERO é obrigatorio")
    private String numeroLoja;

    @NotBlank(message = "O campo INVESTIMENTO é obrigatorio")
    private String investimentoLoja;


    private Cliente cliente ;

    public LojaDTO() {
        super();
    }

    public LojaDTO(Integer idLoja, String nomeLoja, String numeroLoja, String investimentoLoja ,Cliente cliente) {
        super();
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
        this.numeroLoja = numeroLoja;
        this.investimentoLoja = investimentoLoja;
        this.cliente = cliente;

    }
    public LojaDTO(Loja loja){
        this.idLoja = loja.getIdLoja();
        this.nomeLoja = loja.getNomeLoja();
        this.numeroLoja = loja.getNumeroLoja();
        this.investimentoLoja = loja.getInvestimentoLoja();
        this.cliente = loja.getCliente();

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
        if(o == null || getClass() != o.getClass()) return false;
        LojaDTO loja = (LojaDTO) o;
        return Objects.equals(idLoja,loja.idLoja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLoja);
    }
}
