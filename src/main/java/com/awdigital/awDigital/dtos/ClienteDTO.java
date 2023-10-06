package com.awdigital.awDigital.dtos;



import com.awdigital.awDigital.models.Loja;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO implements Serializable {

    private static final long serialVersion = 1L;


    private Integer idCliente;
    @NotBlank(message = "Campo NOME é obrigatório")
    private String nomeCliente;
    @NotBlank(message = "Campo CNPJ é obrigatório")
    private String cnpj;
    @NotBlank(message = "Campo NUMERO CONTATO é obrigatório")
    private String numeroContato;
    @NotBlank(message = "Campo VALOR DA GESTÃO é obrigatório")
    private String valorGestao;
    @NotBlank(message = "Campo DIA DE PAGAMENTO é obrigatório")
    private String diaPagamento;
    @Min(value = 1, message = "A QUANTIDADE DE LOJAS tem que ser no minimo 1")
    private int qntdLojas;




}
