package com.vinizorza.seguradoraveiculo.dto;

import com.vinizorza.seguradoraveiculo.model.Apolice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApoliceDTO {

    private Long numero;
    private Date vigenciaInicio;
    private Date vigenciaFim;
    private String placaVeiculo;
    private Double valor;
    private ClienteDTO clienteDTO;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(Date vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public Date getVigenciaFim() {
        return vigenciaFim;
    }

    public void setVigenciaFim(Date vigenciaFim) {
        this.vigenciaFim = vigenciaFim;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public static ApoliceDTO from (Apolice entity){
        ApoliceDTO dto = new ApoliceDTO();
        dto.setClienteDTO(ClienteDTO.from(entity.getCliente()));
        dto.setNumero(entity.getNumero());
        dto.setValor(entity.getValor());
        dto.setPlacaVeiculo(entity.getPlacaVeiculo());
        dto.setVigenciaFim(entity.getVigenciaFim());
        dto.setVigenciaInicio(entity.getVigenciaInicio());
        return dto;
    }

    public static List<ApoliceDTO> from (List<Apolice> entities){
        List<ApoliceDTO> dtos = new ArrayList<>();
        for (Apolice entity: entities) {
            dtos.add(ApoliceDTO.from(entity));
        }
        return dtos;
    }

}
