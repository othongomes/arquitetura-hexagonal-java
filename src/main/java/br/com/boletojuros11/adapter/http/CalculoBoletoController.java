package br.com.boletojuros11.adapter.http;

import br.com.boletojuros11.adapter.datasource.mapper.BoletoCalculadoMapper;
import br.com.boletojuros11.adapter.http.dto.CalculoBoletoRequest;
import br.com.boletojuros11.adapter.http.dto.CalculoBoletoResponse;
import br.com.boletojuros11.adapter.http.mapper.CalculoBoletoMapper;
import br.com.boletojuros11.core.port.in.CalculoBoletoPort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {

    private final CalculoBoletoPort calculoBoletoPort;
    private final CalculoBoletoMapper mapper;

    public CalculoBoletoController(CalculoBoletoPort calculoBoletoPort, CalculoBoletoMapper mapper) {
        this.calculoBoletoPort = calculoBoletoPort;
        this.mapper = mapper;
    }

    @PostMapping("/calculo")
    @Operation(summary = "calcular juros de um boleto")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto) {
        var boletoCalculado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());
        return ResponseEntity.ok(mapper.toDTO(boletoCalculado));
    }

}
