package com.vinizorza.seguradoraveiculo.controller;

import com.vinizorza.seguradoraveiculo.dto.ApoliceDTO;
import com.vinizorza.seguradoraveiculo.model.Apolice;
import com.vinizorza.seguradoraveiculo.service.ApoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ApoliceController {

    @Autowired
    private ApoliceService apoliceService;

    @PostMapping("/apolice")
    public void create(@Valid @RequestBody Apolice apolice){
        apoliceService.create(apolice);
    }

    @GetMapping("/apolice")
    public List<ApoliceDTO> list(){
       return apoliceService.list();
    }

    @GetMapping("/apolice/{id}")
    public ApoliceDTO getById(@PathVariable Long id){
        return apoliceService.getById(id);
    }

    @DeleteMapping("/apolice/{id}")
    public void deleteById(@PathVariable Long id){
        apoliceService.deleteById(id);
    }

}
