package dev.lira.lojavirtual.produto.application.service;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoDetalhadoReponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoListResponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    ProdutoResponse postProduto(ProdutoRequest produtoRequest);
    List<ProdutoListResponse> getAllProdutos();
    ProdutoDetalhadoReponse getProdutoById(UUID idProduto);
    void patchProdutoById(UUID idProduto, ProdutoPatchRequest produtoPatchRequest);
    void alteraStatusProdutoParaEmEstoque(UUID idProduto);
    void alteraStatusProdutoParaForaDeEstoque(UUID idProduto);
    void deletaProduto(UUID idProduto);
}
