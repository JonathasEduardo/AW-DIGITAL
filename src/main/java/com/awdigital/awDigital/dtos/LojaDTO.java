package com.awdigital.awDigital.dtos;

import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.models.Loja;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LojaDTO implements Serializable {


    private static final long serialVersionUID = 1L;

Cliente cliente1 = new Cliente();
    private Integer idLoja;

    @NotBlank(message = "O campo Nome é obrigatorio")
    private String nomeLoja;

    @NotBlank(message = "O campo NUMERO é obrigatorio")
    private String numeroLoja;

    @NotBlank(message = "O campo INVESTIMENTO é obrigatorio")
    private String investimentoLoja;


    private Integer cliente ;

    public LojaDTO(Integer idLoja, String nomeLoja, String numeroLoja, String investimentoLoja) {
        super();
        this.idLoja = idLoja;
        this.nomeLoja = nomeLoja;
        this.numeroLoja = numeroLoja;
        this.investimentoLoja = investimentoLoja;

    }

    public LojaDTO() {
    }
    public LojaDTO(Loja loja){
        this.idLoja = loja.getIdLoja();
        this.nomeLoja = loja.getNomeLoja();
        this.numeroLoja = loja.getNumeroLoja();
        this.investimentoLoja = loja.getInvestimentoLoja();
        this.cliente = getCliente();
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

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }
}
