package dev.lira.lojavirtual.itemCarrinho.application.api.response;

import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class ItemCarrinhoResponse {
    private Long idItemCarrinho;
    private Produto produto;
    private int quantidade;
    private BigDecimal subtotal;
    private LocalDateTime dataHoraCriacao;
}
