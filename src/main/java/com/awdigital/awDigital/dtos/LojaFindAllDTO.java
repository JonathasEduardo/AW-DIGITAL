package com.awdigital.awDigital.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LojaFindAllDTO implements Serializable {


    private static final long serialVersionUID = 1L;


    private Integer idLoja;


    private String nomeLoja;


    private String numeroLoja;


    private String investimentoLoja;


    private ClienteDTO clienteDTO;

}