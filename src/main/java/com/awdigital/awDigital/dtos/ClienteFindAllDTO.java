package com.awdigital.awDigital.dtos;

import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.models.Loja;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteFindAllDTO implements Serializable {

    private static final long seriaVersionUID = 1L;

    private Integer idCliente;
    private String nomeCliente;
    private String cnpj;
    private String numeroContato;
    private String valorGestao;
    private String diaPagamento;
    private int qntdLojas;
    private List<Loja> loja;




}
