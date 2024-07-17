package br.com.boletojuros11.adapter.http.dto;

import br.com.boletojuros11.core.domain.enums.TipoBoleto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CalculoBoletoResponse {

    private String codigo;

    @JsonProperty("data_vencimento")
    private LocalDate dataVencimento;

    private BigDecimal valor;

    private TipoBoleto tipo;

}