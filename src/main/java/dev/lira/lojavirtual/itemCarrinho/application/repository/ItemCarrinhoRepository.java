package dev.lira.lojavirtual.itemCarrinho.application.repository;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface ItemCarrinhoRepository {
    ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho);
    ItemCarrinho findById(Long idItemCarrinho);
    void delete(ItemCarrinho item);
}
