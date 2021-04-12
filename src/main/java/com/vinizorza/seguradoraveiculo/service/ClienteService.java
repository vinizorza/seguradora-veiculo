package com.vinizorza.seguradoraveiculo.service;

import com.vinizorza.seguradoraveiculo.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface ClienteService {

    void create(Cliente cliente);

    List<Cliente> list();

    Cliente getById(Long id);

    void deleteById(Long id);

}
