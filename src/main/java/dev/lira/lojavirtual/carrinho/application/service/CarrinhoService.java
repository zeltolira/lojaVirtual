package dev.lira.lojavirtual.carrinho.application.service;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;

import java.util.UUID;

public interface CarrinhoService {
    CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest);
//    ItemCarrinhoResponse adicionaItemCarrinho(Long idCarrinho, UUID idProduto, int quantidade);
    CarrinhoDetalhadoResponse getCarrinhoById(Long idCarrinho);
    void deleleCarrinhoById(Long idCarrinho);
}
