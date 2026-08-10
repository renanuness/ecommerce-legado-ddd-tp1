package br.edu.infnet.ecommerce.paymentcontext.repository;

import br.edu.infnet.ecommerce.paymentcontext.domain.repository.PagamentoRepository;
import br.edu.infnet.ecommerce.paymentcontext.repository.models.Pagamento;

import java.util.Optional;

public class PagamentoRepositoryImpl implements PagamentoRepository {
    @Override
    public Optional<Pagamento> findByPedidoId(Long pedidoId) {
        return Optional.empty();
    }
}
