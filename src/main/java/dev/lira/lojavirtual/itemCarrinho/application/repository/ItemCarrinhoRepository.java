package dev.lira.lojavirtual.itemCarrinho.application.repository;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface ItemCarrinhoRepository {
    ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho);
    ItemCarrinho findByIdItemCarrinho(Long idItemCarrinho);
    void delete(ItemCarrinho item);
}
