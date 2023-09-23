package com.awdigital.awDigital.services;

import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.models.Loja;
import com.awdigital.awDigital.repositorys.ClienteRepository;
import com.awdigital.awDigital.repositorys.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;


@Service
public class DBService {


    LocalDate dataPagamento = LocalDate.of(2023, 8, 12);


    @Autowired//Springboot gerencia
    private ClienteRepository clienteRepository;//Estanciar pelo spring

    @Autowired
    private LojaRepository lojaRepository;

    @Transactional
    public void instanciaDB() {


        Cliente c1 = new Cliente(null, "Paulo Silva", "79.015.111/0001-21", "(87) 99317-6357", 1, "R$:600,00", dataPagamento);

        Cliente c2 = new Cliente(null, "Carolina Tereza Rezende", "32.645.478/0001-65", "(81) 99313-6326", 1, "R$:900,00", dataPagamento);

        Cliente c3 = new Cliente(null, "Felipe Calebe Alves", "85.849.611/0001-61", "(81) 98172-2380", 1, "R$:1000,00", dataPagamento);

        Cliente c4 = new Cliente(null, "Luzia Sara Barbosa", "96.868.392/0001-84", "(81) 98814-2813", 1, "R$:800,00", dataPagamento);

        Loja l1 = new Loja(null, "Doces & Salgados ME", "(81) 98886-1655", "R$:300,00", c1);
        Loja l2 = new Loja(null, "Pizzaria Delivery ME", "(81) 99254-2748", "R$:300,00", c2);
        Loja l3 = new Loja(null, "Pães e Doces Ltda", "(81) 98886-1655", "R$:300,00", c3);
        Loja l4 = new Loja(null, "Luzia Buffet ME", "(81) 98886-1655", "R$:300,00", c4);


        c1.getLoja().add(l1);
        c2.getLoja().add(l2);
        c3.getLoja().add(l3);
        c4.getLoja().add(l4);

        clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        lojaRepository.saveAll(Arrays.asList(l1, l2, l3, l4));

    }
}
