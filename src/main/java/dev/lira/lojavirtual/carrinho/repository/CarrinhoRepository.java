package dev.lira.lojavirtual.carrinho.repository;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface CarrinhoRepository {
    Carrinho postCarrinho(Carrinho carrinho);
    Carrinho getCarrinhoById(Long idCarrinho);
    void adicionaItemCarrinho(ItemCarrinho itemCarrinho);
}
