package com.awdigital.awDigital.services;

import com.awdigital.awDigital.dtos.LojaDTO;
import com.awdigital.awDigital.dtos.LojaFindAllDTO;
import com.awdigital.awDigital.exceptions.ObjectNoteFoundException;
import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.models.Loja;
import com.awdigital.awDigital.repositorys.LojaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    public Loja findById(Integer id){
        Optional<Loja> livro = lojaRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNoteFoundException("Loja não encontrada"));
    }



    public List<LojaFindAllDTO> findAll(Integer id_cat) {
        List<Loja> lojas = lojaRepository.findAllByCliente(id_cat);
        return lojas.stream().map(loja -> mapToLojaFindAllDTO(loja)).collect(Collectors.toList());
    }

    public Loja save(Integer id_cat, LojaDTO lojaDTO){
        lojaDTO.setIdLoja(null);
        Loja loja = new Loja();
        Cliente cat = clienteService.findById(id_cat);
        lojaDTO.setCliente(cat);

        dtooTOEntity(loja, lojaDTO);

        return lojaRepository.save(loja);
    }

    public Loja upDate(Integer id, LojaDTO lojaDTO){
        lojaDTO.setIdLoja(id);
        Loja loja = new Loja();
        dtooTOEntity(loja, lojaDTO);

        return lojaRepository.save(loja);

    }

    public void delete(Integer id){
        findById(id);
        lojaRepository.deleteById(id);
    }



    private void dtooTOEntity(Loja loja, LojaDTO lojaDTO){
        loja.setIdLoja(lojaDTO.getIdLoja());
        loja.setNomeLoja(lojaDTO.getNomeLoja());
        loja.setNumeroLoja(lojaDTO.getNumeroLoja());
        loja.setInvestimentoLoja(lojaDTO.getInvestimentoLoja());
        loja.setCliente(lojaDTO.getCliente());
    }

    //Metodo auxiliares

    private LojaFindAllDTO mapToLojaFindAllDTO(Loja loja) {
        LojaFindAllDTO dto = new LojaFindAllDTO();
        dto.setIdLoja(loja.getIdLoja());
        dto.setNomeLoja(loja.getNomeLoja());
        dto.setNumeroLoja(loja.getNumeroLoja());
        dto.setInvestimentoLoja(loja.getInvestimentoLoja());
        dto.setClienteDTO(clienteService.mapToClienteDTO(loja.getCliente()));
        return dto;
    }

}
