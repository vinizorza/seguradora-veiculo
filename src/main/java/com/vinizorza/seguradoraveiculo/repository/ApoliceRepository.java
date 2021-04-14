package com.vinizorza.seguradoraveiculo.repository;

import com.vinizorza.seguradoraveiculo.model.Apolice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApoliceRepository extends MongoRepository<Apolice, Long> {
}
