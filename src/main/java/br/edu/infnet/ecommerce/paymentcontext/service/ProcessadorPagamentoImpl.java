package br.edu.infnet.ecommerce.paymentcontext.domain.models;

import br.edu.infnet.ecommerce.paymentcontext.domain.models.enums.FormaPagamento;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class ProcessadorPagamentoImpl implements br.edu.infnet.ecommerce.paymentcontext.service.ProcessadorPagamento {

    /*
     * Implementação concreta usada diretamente pelos services.
     * Não existe uma porta, interface ou contrato de integração.
     */
    public ResultadoProcessamento processar(
            BigDecimal valor,
            FormaPagamento formaPagamento,
            String numeroCartao
    ) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            return ResultadoProcessamento.recusado("VALOR_INVALIDO");
        }

        if (formaPagamento != FormaPagamento.CARTAO_CREDITO) {
            return ResultadoProcessamento.recusado("FORMA_PAGAMENTO_NAO_SUPORTADA");
        }

        if (numeroCartao == null || numeroCartao.length() < 4) {
            return ResultadoProcessamento.recusado("CARTAO_INVALIDO");
        }

        if (valor.compareTo(new BigDecimal("10000.00")) > 0) {
            return ResultadoProcessamento.recusado("LIMITE_EXCEDIDO");
        }

        if (numeroCartao.endsWith("0000")) {
            return ResultadoProcessamento.recusado("CARTAO_BLOQUEADO");
        }

        return ResultadoProcessamento.aprovado(
                UUID.randomUUID().toString().substring(0, 8).toUpperCase()
        );
    }
}
