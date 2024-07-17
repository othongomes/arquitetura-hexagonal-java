package br.com.boletojuros11.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

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
