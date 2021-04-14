package com.vinizorza.seguradoraveiculo.dto;

import com.vinizorza.seguradoraveiculo.model.Apolice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApoliceCompletaDTO {

    private Long numero;
    private Date vigenciaInicio;
    private Date vigenciaFim;
    private String placaVeiculo;
    private Double valor;
    private ClienteDTO clienteDTO;
    private boolean isVencida;
    private long diasRestantes;

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

    public boolean isVencida() {
        return isVencida;
    }

    public void setVencida(boolean vencida) {
        isVencida = vencida;
    }

    public long getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(long diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    public static ApoliceCompletaDTO from (Apolice entity){
        ApoliceCompletaDTO dto = new ApoliceCompletaDTO();
        dto.setClienteDTO(ClienteDTO.from(entity.getCliente()));
        dto.setNumero(entity.getNumero());
        dto.setValor(entity.getValor());
        dto.setPlacaVeiculo(entity.getPlacaVeiculo());
        dto.setVigenciaFim(entity.getVigenciaFim());
        dto.setVigenciaInicio(entity.getVigenciaInicio());
        dto.setDiasRestantes(entity.getDiasRestantes());
        dto.setVencida(entity.isVencida());
        return dto;
    }

    public static List<ApoliceCompletaDTO> from (List<Apolice> entities){
        List<ApoliceCompletaDTO> dtos = new ArrayList<>();
        for (Apolice entity: entities) {
            dtos.add(ApoliceCompletaDTO.from(entity));
        }
        return dtos;
    }

}
