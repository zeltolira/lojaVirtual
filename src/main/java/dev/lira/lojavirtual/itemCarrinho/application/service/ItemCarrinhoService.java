package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;

import java.util.UUID;

public interface ItemCarrinhoService {
    ItemCarrinhoResponse adicionaItemCarrinho(UUID idProduto, ItemCarrinhoRequest itemCarrinhoRequest);
}
