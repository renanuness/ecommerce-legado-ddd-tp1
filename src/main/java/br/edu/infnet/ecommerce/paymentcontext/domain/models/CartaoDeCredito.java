package br.edu.infnet.ecommerce.paymentcontext.domain.models;

public record CartaoDeCredito(
String numero) {

    public String mascarar() {
        if (this.numero == null || this.numero.length() < 4) {
            return "****";
        }

        return "**** **** **** " + this.numero.substring(this.numero.length() - 4);
    }
}

