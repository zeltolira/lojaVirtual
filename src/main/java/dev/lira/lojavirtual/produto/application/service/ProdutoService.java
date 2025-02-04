package dev.lira.lojavirtual.produto.application.service;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoListResponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
    ProdutoResponse postProduto(ProdutoRequest produtoRequest);

    List<ProdutoListResponse> getAllProdutos();
}
