package br.com.boletojuros11.core.port.out;

import br.com.boletojuros11.core.domain.BoletoCalculado;

public interface SalvarCalculoBoletoPort {
    void executar(BoletoCalculado boletoCalculado);
}
