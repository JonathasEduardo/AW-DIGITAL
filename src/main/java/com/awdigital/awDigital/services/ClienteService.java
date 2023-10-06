package com.awdigital.awDigital.services;

import com.awdigital.awDigital.dtos.ClienteDTO;
import com.awdigital.awDigital.exceptions.DataIntegrityViolationException;
import com.awdigital.awDigital.exceptions.IllegalArgument;
import com.awdigital.awDigital.exceptions.ObjectNoteFoundException;
import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.repositorys.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Cliente findById(Integer id){
        Optional<Cliente> cat = clienteRepository.findById(id);
        return cat.orElseThrow(() -> new ObjectNoteFoundException("Cliente não encontrado !!"));
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }



    public Cliente save(ClienteDTO objDTO){
        findByNome(objDTO);
        objDTO.setIdCliente(null);
        return clienteRepository.save(modelMapper.map(objDTO, Cliente.class));
    }

    public Cliente upDate(ClienteDTO objDTO){
        findById(objDTO.getIdCliente());// validação para ver se existe
        return clienteRepository.save(modelMapper.map(objDTO, Cliente.class));//modelmapper transforma em DTO
    }

    public void delete(Integer id){
        findById(id);
        Optional<Cliente> cat = clienteRepository.findById(id);
        if(cat.get().getLoja().size() > 0){
            throw new DataIntegrityViolationException("Existem lojas vinculados a esse cliente, NÃO PODE SER DELETADA");
        }
        clienteRepository.deleteById(id);
    }


    // metodos auxiliares


    private void findByNome(ClienteDTO objDTO){

        Optional<Cliente> cat = clienteRepository.findByNomeCliente(objDTO.getNomeCliente());

        if(cat.isPresent() && cat.get().getNomeCliente().equals(objDTO.getNomeCliente())) {
            throw new IllegalArgumentException("Já existe um cliente com este nome: " + objDTO.getNomeCliente() + " com o ID: " + objDTO.getIdCliente());
        }
    }

    private void buscarPorNome(ClienteDTO objDTO){
        Optional<Cliente> cat = clienteRepository.findByNomeCliente(objDTO.getNomeCliente());
        if (cat.isPresent() && !cat.get().equals(objDTO.getIdCliente())){
            throw new IllegalArgument("Este ID: " + objDTO.getIdCliente() + "não pertence a este cliente.");
        }
    }

    public void encontrarPorNome(String NomeCliente){
        Optional<Cliente> cat = clienteRepository.findByNomeClienteContaining(NomeCliente);
        if(cat.isEmpty()){
            throw new ObjectNoteFoundException("Cliente não encontrado");
        }
    }
}
