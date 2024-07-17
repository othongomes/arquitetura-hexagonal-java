package br.com.boletojuros11.adapter.datasource.mapper;

import br.com.boletojuros11.adapter.datasource.integration.dto.BoletoDTO;
import br.com.boletojuros11.core.domain.Boleto;
import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoMapper {
    Boleto toDoamin(BoletoDTO boletoDTO);
}
