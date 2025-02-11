package dev.lira.lojavirtual.itemCarrinho.application.api.request;

import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ItemCarrinhoRequest {
    private Produto produto;
    private int quantidade;

    public void calcularSubTotal() {

    }


}
