package dev.lira.lojavirtual.itemCarrinho.application.api.response;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ItemCarrinhoResponse {
    private UUID idProduto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemCarrinhoResponse(ItemCarrinho itemCarrinho) {
        this.idProduto = itemCarrinho.getProduto().getIdProduto();
        this.quantidade = itemCarrinho.getQuantidade();
        this.subtotal = itemCarrinho.getSubtotal();
    }
}
