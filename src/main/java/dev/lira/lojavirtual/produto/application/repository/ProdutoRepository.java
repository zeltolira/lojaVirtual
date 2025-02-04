package dev.lira.lojavirtual.produto.application.repository;

import dev.lira.lojavirtual.produto.domain.Produto;

import java.util.List;

public interface ProdutoRepository {
    Produto saveProduto(Produto produto);

    List<Produto> getAllProdutos();
}
