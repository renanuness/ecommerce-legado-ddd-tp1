package br.edu.infnet.ecommerce.paymentcontext.domain.models;

import br.edu.infnet.ecommerce.entity.Pedido;
import br.edu.infnet.ecommerce.entity.Usuario;
import br.edu.infnet.ecommerce.paymentcontext.domain.models.enums.FormaPagamento;
import br.edu.infnet.ecommerce.paymentcontext.domain.models.enums.StatusPagamento;

import java.time.LocalDateTime;

public class Pagamento {

    private Long id;
    private Pedido pedido;
    private Usuario usuario;
    private ValorMonetario valor;
    private FormaPagamento formaPagamento;
    private CartaoDeCredito cartaoDeCredito;
    private StatusPagamento status;
    private String motivo;
    private String codigoAutorizacao;
    private LocalDateTime processadoEm;


    private Pagamento(Long id, Pedido pedido, Usuario usuario, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {
        this.id = id;
        this.pedido = pedido;
        this.usuario = usuario;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.cartaoDeCredito = cartaoDeCredito;
        this.status = status;
        this.motivo = motivo;
        this.codigoAutorizacao = codigoAutorizacao;
        this.processadoEm = processadoEm;
    }

    private Pagamento(Pedido pedido, Usuario usuario, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {
        this.pedido = pedido;
        this.usuario = usuario;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.cartaoDeCredito = cartaoDeCredito;
        this.status = status;
        this.motivo = motivo;
        this.codigoAutorizacao = codigoAutorizacao;
        this.processadoEm = processadoEm;
    }


    public static Pagamento novoPagamento(Pedido pedido, Usuario usuario, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {

        var pagamento = new Pagamento(
                pedido,
                usuario,
                valor,
                formaPagamento,
                cartaoDeCredito,
                status,
                motivo,
                codigoAutorizacao,
                processadoEm);

        return pagamento;
    }

    public static Pagamento existente(Long id, Pedido pedido, Usuario usuario, ValorMonetario valor, FormaPagamento formaPagamento, CartaoDeCredito cartaoDeCredito, StatusPagamento status, String motivo, String codigoAutorizacao, LocalDateTime processadoEm) {
        var pagamento = new Pagamento(
                id,
                pedido,
                usuario,
                valor,
                formaPagamento,
                cartaoDeCredito,
                status,
                motivo,
                codigoAutorizacao,
                processadoEm);

        return pagamento;
    }

    public boolean foiAprovado(){
        return status == StatusPagamento.APROVADO;
    }

    public String motivo(){ return motivo; }
    public Pedido 
    public Usuario usuario(){ return usuario; }
}
