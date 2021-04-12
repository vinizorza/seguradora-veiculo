package com.vinizorza.seguradoraveiculo.controller;

import com.vinizorza.seguradoraveiculo.model.Cliente;
import com.vinizorza.seguradoraveiculo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public void create(@Valid @RequestBody Cliente cliente){
        clienteService.create(cliente);
    }

    @GetMapping("/cliente")
    public List<Cliente> list(){
       return clienteService.list();
    }

    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable Long id){
        return clienteService.getById(id);
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteById(@PathVariable Long id){
        clienteService.deleteById(id);
    }

}
