package dev.lira.lojavirtual.produto.application.service;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;

public interface ProdutoService {
    ProdutoResponse postProduto(ProdutoRequest produtoRequest);
}
