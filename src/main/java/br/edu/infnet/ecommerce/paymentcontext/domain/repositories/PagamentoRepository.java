package br.edu.infnet.ecommerce.paymentcontext.domain.repositories;

import br.edu.infnet.ecommerce.paymentcontext.domain.models.Pagamento;

import java.util.Optional;

public interface PagamentoRepository{
    Optional<Pagamento> findByPedidoId(Long pedidoId);
    Pagamento save(Pagamento pagamento);
}
