package com.vinizorza.seguradoraveiculo.dto;

import com.vinizorza.seguradoraveiculo.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String cidade;
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public static ClienteDTO from (Cliente entity){
        ClienteDTO dto = new ClienteDTO();
        dto.setCidade(entity.getCidade());
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setUf(entity.getUf());
        dto.setCpf(entity.getCpf());
        return dto;
    }

    public static List<ClienteDTO> from (List<Cliente> entities){
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente entity: entities) {
            dtos.add(ClienteDTO.from(entity));
        }
        return dtos;
    }
}
