package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;

import java.util.UUID;

public interface ItemCarrinhoService {
    ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest);
    void deletaItemCarrinho(Long idCarrinho, Long idItemCarrinho, UUID idProduto);
}
