package dev.lira.lojavirtual.itemCarrinho.application.api.response;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemCarrinhoDetalhadoResponse {
    private UUID idProduto;
    private int quantidade;
    private BigDecimal subtotal;

    public ItemCarrinhoDetalhadoResponse(ItemCarrinho itemCarrinho) {
        this.idProduto = itemCarrinho.getProduto().getIdProduto();
        this.quantidade = itemCarrinho.getQuantidade();
        this.subtotal = itemCarrinho.getSubtotal();
    }
}
