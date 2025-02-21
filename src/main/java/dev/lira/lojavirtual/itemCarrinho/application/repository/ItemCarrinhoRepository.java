package dev.lira.lojavirtual.itemCarrinho.application.repository;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface ItemCarrinhoRepository {
    ItemCarrinho postItemCarrinho(ItemCarrinho itemCarrinho);
    ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho);
}
