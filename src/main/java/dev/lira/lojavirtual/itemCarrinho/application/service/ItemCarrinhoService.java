package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

public interface ItemCarrinhoService {
    ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest);
}
