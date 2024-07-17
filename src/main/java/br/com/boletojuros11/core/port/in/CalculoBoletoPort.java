package br.com.boletojuros11.core.port.in;

import br.com.boletojuros11.core.domain.BoletoCalculado;

import java.time.LocalDate;

public interface CalculoBoletoPort {
    BoletoCalculado executar(String codigo, LocalDate dataPagamento);
}
