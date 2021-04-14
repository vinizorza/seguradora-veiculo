package com.vinizorza.seguradoraveiculo.service.impl;

import br.com.caelum.stella.validation.CPFValidator;
import com.vinizorza.seguradoraveiculo.dto.ClienteDTO;
import com.vinizorza.seguradoraveiculo.exception.BadRequestException;
import com.vinizorza.seguradoraveiculo.model.Cliente;
import com.vinizorza.seguradoraveiculo.repository.ClienteRepository;
import com.vinizorza.seguradoraveiculo.service.ClienteService;
import com.vinizorza.seguradoraveiculo.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public void create(Cliente cliente){
        validateCpf(cliente.getCpf());
        if(cliente.getId() == null){
            cliente.setId(sequenceGeneratorService.generateSequence(Cliente.SEQUENCE_NAME));
        }else{
            validateClienteExistente(cliente.getId());
        }
        clienteRepository.save(cliente);
    }

    private void validateClienteExistente(Long id) {
        if(!clienteRepository.findById(id).isPresent())
            throw new BadRequestException("Id do cliente inválido");
    }

    private void validateCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try{
            cpfValidator.assertValid(cpf);
        }catch (Exception e){
            throw new BadRequestException("Cpf inválido");
        }
    }

    public List<ClienteDTO> list(){
        return ClienteDTO.from(clienteRepository.findAll());
    }

    public ClienteDTO getById(Long id){
        validateClienteExistente(id);
        return ClienteDTO.from(clienteRepository.findById(id).get());
    }

    public void deleteById(Long id){
        validateClienteExistente(id);
        clienteRepository.deleteById(id);
    }
}
