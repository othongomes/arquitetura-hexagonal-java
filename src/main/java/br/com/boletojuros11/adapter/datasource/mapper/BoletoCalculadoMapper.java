package br.com.boletojuros11.adapter.datasource.mapper;

import br.com.boletojuros11.adapter.datasource.database.entity.BoletoCalculadoEntity;
import br.com.boletojuros11.core.domain.BoletoCalculado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoletoCalculadoMapper {

   BoletoCalculadoEntity toEntity(BoletoCalculado boletoCalculado);
}
