package br.com.boletojuros11.core.usecase;


import br.com.boletojuros11.core.domain.Boleto;
import br.com.boletojuros11.core.domain.BoletoCalculado;
import br.com.boletojuros11.core.domain.enums.TipoBoleto;
import br.com.boletojuros11.core.domain.enums.TipoExecao;
import br.com.boletojuros11.core.exception.ApplicationException;
import br.com.boletojuros11.core.port.in.CalculoBoletoPort;
import br.com.boletojuros11.core.port.out.ComplementoBoletoPort;
import br.com.boletojuros11.core.port.out.SalvarCalculoBoletoPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalcularBoleto implements CalculoBoletoPort {

    private static final BigDecimal JUROS_DIARIO = BigDecimal.valueOf(0.033);

    private final ComplementoBoletoPort complementoBoletoPort;
    private final SalvarCalculoBoletoPort salvarCalculoBoletoPort;


    public CalcularBoleto(ComplementoBoletoPort complementoBoletoPort, SalvarCalculoBoletoPort salvarCalculoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
        this.salvarCalculoBoletoPort = salvarCalculoBoletoPort;
    }

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {

        var boleto = complementoBoletoPort.executar(codigo);

        // TODO - validar boleto
        validar(boleto);

        // TODO - calcular boleto
        var diasVencidos = getDiasVencidos(boleto.getDataVencimento(), dataPagamento);
        var valorJurosDia = JUROS_DIARIO.multiply(boleto.getValor()).divide(new BigDecimal(100));
        var juros = valorJurosDia.multiply(new BigDecimal(diasVencidos)).setScale(2, RoundingMode.HALF_EVEN);
        var boletoCalculado = BoletoCalculado.builder()
                .codigo(boleto.getCodigo())
                .dataPagamento(dataPagamento)
                .juros(juros)
                .dataVencimento(boleto.getDataVencimento())
                .valorOriginal(boleto.getValor())
                .valor(boleto.getValor().add(juros))
                .tipo(boleto.getTipo())
                .build();

        // TODO - salvar boleto
        salvarCalculoBoletoPort.executar(boletoCalculado);

        return boletoCalculado;
    }


    private void validar(Boleto boleto) {

        if (boleto == null) {
            throw new ApplicationException(TipoExecao.BOLETO_INVALIDO);
        }

        if (boleto.getTipo() != TipoBoleto.XPTO) {
            throw new ApplicationException(TipoExecao.TIPO_BOLETO_INVALIDO);
        }

        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException(TipoExecao.BOLETO_NAO_VENCIDO);
        }
    }

    private Long getDiasVencidos(LocalDate dataVencimento, LocalDate dataPagamento) {
        return ChronoUnit.DAYS.between(dataVencimento, dataPagamento);
    }
}
