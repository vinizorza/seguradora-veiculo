package com.vinizorza.seguradoraveiculo.controller;

import com.vinizorza.seguradoraveiculo.model.Cliente;
import com.vinizorza.seguradoraveiculo.repository.ClienteRepository;
import com.vinizorza.seguradoraveiculo.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/cliente")
    public void create(@Valid @RequestBody Cliente cliente){
        cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
        clienteRepository.save(cliente);
    }

    @GetMapping("/cliente")
    public List<Cliente> list(){
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente getById(@PathVariable int id){
        return clienteRepository.findById(id).get();
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteById(@PathVariable int id){
        clienteRepository.deleteById(id);
    }

}