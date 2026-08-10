package br.edu.infnet.ecommerce.paymentcontext.domain.models;

public record CartaoDeCredito(
String numero) {

    private String mascarar(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.length() < 4) {
            return "****";
        }

        return "**** **** **** " + numeroCartao.substring(numeroCartao.length() - 4);
    }
}

