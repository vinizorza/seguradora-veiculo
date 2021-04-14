package com.vinizorza.seguradoraveiculo.service;

import com.vinizorza.seguradoraveiculo.dto.ApoliceCompletaDTO;
import com.vinizorza.seguradoraveiculo.dto.ApoliceDTO;
import com.vinizorza.seguradoraveiculo.model.Apolice;

import java.util.List;

public interface ApoliceService {

    void create(Apolice apolice);

    List<ApoliceDTO> list();

    ApoliceDTO getById(Long id);

    ApoliceCompletaDTO getCompletaById(Long id);

    void deleteById(Long id);

}
