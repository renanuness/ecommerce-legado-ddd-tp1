package br.edu.infnet.ecommerce.events;

import java.time.LocalDateTime;

public class PedidoConcluido {
    private Long pedidoId;
    private Long usuarioId;
    private LocalDateTime dataPedido;
    private double valorPedido;
}
