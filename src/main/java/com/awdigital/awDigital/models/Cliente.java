package com.awdigital.awDigital.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersion = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)// Criando uma sequencia de ID's
    @Id
    private Integer idCliente;
    private String nomeCliente;
    private String cnpj;
    private String numeroContato;
    private int qntdLojas;


    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Loja> lojas = new ArrayList<>();


    private String valorGestao;


    private LocalDate diaPagamento;


    public Cliente(Integer idCliente, String nomeCliente, String cnpj, String numeroContato, int qntdLojas, String valorGestao, LocalDate diaPagamento) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cnpj = cnpj;
        this.numeroContato = numeroContato;
        this.qntdLojas = qntdLojas;
        this.valorGestao = valorGestao;
        this.diaPagamento = diaPagamento;
    }

    public Cliente() {
    }


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public List<Loja> getLoja() {
        return lojas;
    }

    public void setLoja(List<Loja> loja) {
        this.lojas = loja;
    }

    public String getValorGestao() {
        return valorGestao;
    }

    public void setValorGestao(String valorGestao) {
        this.valorGestao = valorGestao;
    }

    public LocalDate getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(LocalDate diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getQntdLojas() == cliente.getQntdLojas() && Objects.equals(getIdCliente(), cliente.getIdCliente()) && Objects.equals(getNomeCliente(), cliente.getNomeCliente()) && Objects.equals(getCnpj(), cliente.getCnpj()) && Objects.equals(getNumeroContato(), cliente.getNumeroContato()) && Objects.equals(getLoja(), cliente.getLoja()) && Objects.equals(getValorGestao(), cliente.getValorGestao()) && Objects.equals(getDiaPagamento(), cliente.getDiaPagamento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCliente(), getNomeCliente(), getCnpj(), getNumeroContato(), getQntdLojas(), getLoja(), getValorGestao(), getDiaPagamento());
    }
}
