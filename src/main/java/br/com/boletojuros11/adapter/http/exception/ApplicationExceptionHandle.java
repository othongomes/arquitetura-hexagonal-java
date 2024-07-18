package br.com.boletojuros11.adapter.http.exception;

import br.com.boletojuros11.core.domain.enums.TipoExecao;
import br.com.boletojuros11.core.exception.ApplicationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApplicationExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> notFound(ApplicationException ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .messages(Arrays.asList(ex.getTipoExecao().getMensagemErro()))
                .error(ex.getTipoExecao().toString().toLowerCase())
                .timestamp(new Date())
                .code(HttpStatus.NOT_FOUND.value())
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        var erros = ex.getFieldErrors().stream()
                .map(item -> item.getField() + " " + item.getDefaultMessage())
                .collect(Collectors.toList());

        var response = ErrorResponse.builder()
                .messages(erros)
                .error(TipoExecao.BOLETO_INVALIDO.toString().toLowerCase())
                .timestamp(new Date())
                .code(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .build();

        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

}
