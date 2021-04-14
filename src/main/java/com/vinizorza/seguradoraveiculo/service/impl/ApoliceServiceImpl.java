package com.vinizorza.seguradoraveiculo.service.impl;

import com.vinizorza.seguradoraveiculo.dto.ApoliceDTO;
import com.vinizorza.seguradoraveiculo.exception.BadRequestException;
import com.vinizorza.seguradoraveiculo.model.Apolice;
import com.vinizorza.seguradoraveiculo.model.Cliente;
import com.vinizorza.seguradoraveiculo.repository.ApoliceRepository;
import com.vinizorza.seguradoraveiculo.service.ApoliceService;
import com.vinizorza.seguradoraveiculo.service.ClienteService;
import com.vinizorza.seguradoraveiculo.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    @Autowired
    private ApoliceRepository apoliceRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public void create(Apolice apolice){
        validateCliente(apolice.getCliente());
        if(apolice.getNumero() == null){
            apolice.setNumero(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
        }else{
            validateApoliceExistente(apolice.getNumero());
        }
        apoliceRepository.save(apolice);
    }

    private void validateCliente(Cliente cliente) {
        clienteService.getById(cliente.getId());
    }

    private void validateApoliceExistente(Long id) {
        if(!apoliceRepository.findById(id).isPresent())
            throw new BadRequestException("Id da apólice inválido");
    }

    public List<ApoliceDTO> list(){
        return ApoliceDTO.from(apoliceRepository.findAll());
    }

    public ApoliceDTO getById(Long numero){
        validateApoliceExistente(numero);
        return ApoliceDTO.from(apoliceRepository.findById(numero).get());
    }

    public void deleteById(Long numero){
        validateApoliceExistente(numero);
        apoliceRepository.deleteById(numero);
    }
}
