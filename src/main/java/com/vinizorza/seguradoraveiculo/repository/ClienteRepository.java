package com.vinizorza.seguradoraveiculo.repository;

import com.vinizorza.seguradoraveiculo.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, Long> {
}
