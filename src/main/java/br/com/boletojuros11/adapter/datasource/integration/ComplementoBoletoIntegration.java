package br.com.boletojuros11.adapter.datasource.integration;

import br.com.boletojuros11.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.boletojuros11.adapter.datasource.mapper.BoletoMapper;
import br.com.boletojuros11.core.domain.Boleto;
import br.com.boletojuros11.core.port.out.ComplementoBoletoPort;
import org.springframework.stereotype.Component;

@Component
public class ComplementoBoletoIntegration implements ComplementoBoletoPort {

    private final ComplementoBoletoClient client;
    private final BoletoMapper mapper;

    public ComplementoBoletoIntegration(ComplementoBoletoClient client, BoletoMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = client.getBoleto(codigo);
        return mapper.toDoamin(boletoDTO);
    }
}
