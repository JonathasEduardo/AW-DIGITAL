package com.awdigital.awDigital.controllers;


import com.awdigital.awDigital.dtos.ClienteDTO;
import com.awdigital.awDigital.dtos.ClienteFindAllDTO;
import com.awdigital.awDigital.models.Cliente;
import com.awdigital.awDigital.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    // GetMapping{id}// buscar categoria por id
    // @GetMapping //buscar todas as categorias
    // @PostMapping // Inserir categoria
    // @PutMapping // Atualizar categoria
    // @DeleteMapping // Deletar categoria

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
        Cliente cat = clienteService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(cat, ClienteDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<ClienteFindAllDTO>> findAll(){
        List<Cliente> listcat = clienteService.findAll();
        return ResponseEntity.ok().body(listcat.stream().map(obj -> modelMapper.map(obj, ClienteFindAllDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cat = clienteService.save(clienteDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, ClienteDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> upDate(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){
        clienteDTO.setIdCliente(id);
        Cliente cat = clienteService.upDate(clienteDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, ClienteDTO.class));
    }

    @DeleteMapping("/{id}")             //PathVariable serve para mostrar o caminho
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();// noContent -> sem conteudo
    }
}
