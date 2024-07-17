package br.com.boletojuros11.adapter.http.mapper;

import br.com.boletojuros11.adapter.http.dto.CalculoBoletoResponse;
import br.com.boletojuros11.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalculoBoletoMapper {

   CalculoBoletoResponse toDTO(BoletoCalculado boletoCalculado);
}
