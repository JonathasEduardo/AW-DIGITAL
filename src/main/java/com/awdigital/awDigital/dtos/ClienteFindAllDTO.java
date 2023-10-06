package com.awdigital.awDigital.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


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




}
