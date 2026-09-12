package br.edu.infnet.ecommerce.paymentcontext.domain.models;

import br.edu.infnet.ecommerce.paymentcontext.domain.models.enums.FormaPagamento;
import br.edu.infnet.ecommerce.paymentcontext.domain.models.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

    private Long id;
    private Long pedidoId;
    private Long usuarioId;
    private ValorMonetario valor;
    private FormaPagamento formaPagamento;
    private CartaoDeCredito cartaoDeCredito;
    private StatusPagamento status;
    private String motivo;
    private String codigoAutorizacao;
    private LocalDateTime processadoEm;

    private Pagamento(Long id, Long pedidoId, Long usuarioId, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.usuarioId = usuarioId;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.cartaoDeCredito = cartaoDeCredito;
        this.status = status;
        this.motivo = motivo;
        this.codigoAutorizacao = codigoAutorizacao;
        this.processadoEm = processadoEm;
    }

    private Pagamento(Long pedidoId, Long usuarioId, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {
        this.pedidoId = pedidoId;
        this.usuarioId = usuarioId;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.cartaoDeCredito = cartaoDeCredito;
        this.status = status;
        this.motivo = motivo;
        this.codigoAutorizacao = codigoAutorizacao;
        this.processadoEm = processadoEm;
    }


    public static Pagamento novoPagamento(Long pedidoId, Long usuarioId, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {

        var pagamento = new Pagamento(
                pedidoId,
                usuarioId,
                valor,
                formaPagamento,
                cartaoDeCredito,
                status,
                motivo,
                codigoAutorizacao,
                processadoEm);

        return pagamento;
    }

    public static Pagamento existente(Long id, Long pedidoId, Long usuarioId, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {
        var pagamento = new Pagamento(
                id,
                pedidoId,
                usuarioId,
                valor,
                formaPagamento,
                cartaoDeCredito,
                status,
                motivo,
                codigoAutorizacao,
                processadoEm);

        return pagamento;
    }

    public void setResultadoProcessamento(ResultadoProcessamento resultado){
        status = resultado.status();
        this.motivo = resultado.motivo();
        this.codigoAutorizacao = resultado.codigoAutorizacao();
    }

    public boolean foiAprovado(){
        return status == StatusPagamento.APROVADO;
    }

    public String getMotivo(){ return motivo; }
    public Long  getPedidoId(){ return pedidoId;}
    public Long getUsuarioId(){ return usuarioId; }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public BigDecimal getValorDecimal() {
        return valor.valor();
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public LocalDateTime getProcessadoEm() {
        return processadoEm;
    }

    public CartaoDeCredito getCartaoDeCredito() {
        return cartaoDeCredito;
    }
}
