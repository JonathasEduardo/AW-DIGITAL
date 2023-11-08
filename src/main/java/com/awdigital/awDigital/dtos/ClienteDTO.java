package com.awdigital.awDigital.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

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
    @NotNull(message = "Campo DIA DE PAGAMENTO é obrigatório")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "A data deve estar no formato dd-MM-yyyy")
    private String diaPagamento;
    @Min(value = 1, message = "A QUANTIDADE DE LOJAS tem que ser no minimo 1")
    private int qntdLojas;

}
