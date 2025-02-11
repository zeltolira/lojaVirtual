package dev.lira.lojavirtual.itemCarrinho.application.repository;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface ItemCarrinhoRepository {
    ItemCarrinho saveItemCarrinho(ItemCarrinho itemCarrinho);
}
