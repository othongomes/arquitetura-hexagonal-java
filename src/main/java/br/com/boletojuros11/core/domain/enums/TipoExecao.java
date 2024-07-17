package br.com.boletojuros11.core.domain.enums;

public enum TipoExecao {
    BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto informado é invalido";
        }
    },
    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "O tipo do boleto precisa estar no formato XPTO";
        }
    },
    BOLETO_NAO_VENCIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto informado não está vencido.";
        }
    };

    public abstract String getMensagemErro();
}
