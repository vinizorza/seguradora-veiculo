package com.vinizorza.seguradoraveiculo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Document(collection = "apolice")
public class Apolice {

    @Transient
    public static final String SEQUENCE_NAME = "apolice_sequence";

    @Id
    private Long numero;

    @NotNull
    private Date vigenciaInicio;

    @NotNull
    private Date vigenciaFim;

    @NotBlank
    @Size(max = 7)
    private String placaVeiculo;

    @NotNull
    private Double valor;

    @NotNull
    private Cliente cliente;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isVencida(){
        return this.vigenciaFim.before(new Date());
    }

    public long getDiasRestantes(){
        return ChronoUnit.DAYS.between(
                new java.sql.Date((new Date()).getTime()).toLocalDate(),
                new java.sql.Date(this.vigenciaFim.getTime()).toLocalDate());
    }


}
