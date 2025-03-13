package dev.lira.lojavirtual.carrinho.repository;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface CarrinhoRepository {
    Carrinho saveCarrinho(Carrinho carrinho);
    Carrinho getCarrinhoById(Long idCarrinho);
    void deleteCarrinho(Carrinho carrinho);
//    void adicionaItemCarrinho(ItemCarrinho itemCarrinho);
}
