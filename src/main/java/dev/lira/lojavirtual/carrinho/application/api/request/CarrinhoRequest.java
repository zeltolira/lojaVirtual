package dev.lira.lojavirtual.carrinho.application.api.request;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CarrinhoRequest {
    private List<ItemCarrinho> itens = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;
    private LocalDateTime dataHoraCriacao;
}
