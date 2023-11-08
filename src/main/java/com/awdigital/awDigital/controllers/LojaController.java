package com.awdigital.awDigital.controllers;


import com.awdigital.awDigital.dtos.LojaDTO;
import com.awdigital.awDigital.dtos.LojaFindAllDTO;
import com.awdigital.awDigital.models.Loja;
import com.awdigital.awDigital.services.LojaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    LojaService lojaService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "{id}")
    ResponseEntity<LojaDTO>findById(@PathVariable Integer id){
        Loja loja = lojaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new LojaDTO(loja));
    }


    @GetMapping
    public ResponseEntity<List<LojaFindAllDTO>> findAllLojasByCliente(@RequestParam(value = "cliente", defaultValue = "0") Integer idCat) {
        List<LojaFindAllDTO> lojasFindAllDTO = lojaService.findAll(idCat);
        return ResponseEntity.ok().body(lojasFindAllDTO);
    }
    /*@GetMapping
    public ResponseEntity<List<LojaDTO>>findAll(@RequestParam(value = "cliente", defaultValue = "0") Integer id_cat){
        List<Loja> list = lojaService.findAll(id_cat);
        return ResponseEntity.ok().body(list.stream().map(x -> new LojaDTO(x)).collect(Collectors.toList()));
       // return ResponseEntity.ok().body(list.stream().map(x -> modelMapper.map(x, LivroDTO.class)).collect(Collectors.toList()));

        //localhost:8080/loja?cliente=valor-do-id
    }*/

    @PostMapping
    public ResponseEntity<LojaDTO>save(@RequestParam(value = "cliente", defaultValue = "0")Integer id_cat,
                                       @Valid @RequestBody LojaDTO lojaDTO){
        Loja loja = lojaService.save(id_cat, lojaDTO);

        return ResponseEntity.ok().body(new LojaDTO(loja));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LojaDTO>upDate(@PathVariable Integer id, @Valid @RequestBody LojaDTO lojaDTO){
        Loja loja = lojaService.upDate(id, lojaDTO);
        return ResponseEntity.ok().body(new LojaDTO(loja));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        lojaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
