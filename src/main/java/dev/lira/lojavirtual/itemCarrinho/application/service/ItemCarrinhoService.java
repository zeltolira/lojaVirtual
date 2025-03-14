package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoPatchResquest;
import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;

import java.util.UUID;

public interface ItemCarrinhoService {
    ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest);
    void deletaItemCarrinho(Long idCarrinho, Long idItemCarrinho, UUID idProduto);
    ItemCarrinhoDetalhadoResponse getItemCarrinho(Long idItemCarrinho);
    void patchItemCarrinhoById(Long idCarrinho, UUID idProduto, ItemCarrinhoPatchResquest itemCarrinhoPatchResquest);
}
