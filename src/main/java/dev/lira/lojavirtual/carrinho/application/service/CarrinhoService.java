package dev.lira.lojavirtual.carrinho.application.service;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;

public interface CarrinhoService {
    CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest);
}
