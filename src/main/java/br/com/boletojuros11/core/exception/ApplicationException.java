package br.com.boletojuros11.core.exception;

import br.com.boletojuros11.core.domain.enums.TipoExecao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {

    private TipoExecao tipoExecao;
}
