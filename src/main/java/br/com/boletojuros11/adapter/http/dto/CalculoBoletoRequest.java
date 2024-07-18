package br.com.boletojuros11.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CalculoBoletoRequest {

    @NotNull
    private String codigo;

    @NotNull
    @JsonProperty("data_pagamento")
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate dataPagamento;
}
