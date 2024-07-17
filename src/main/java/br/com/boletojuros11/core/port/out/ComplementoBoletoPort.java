package br.com.boletojuros11.core.port.out;

import br.com.boletojuros11.core.domain.Boleto;

public interface ComplementoBoletoPort {
    Boleto executar(String codigo);
}
