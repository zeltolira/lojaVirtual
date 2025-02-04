package dev.lira.lojavirtual.produto.application.repository;

import dev.lira.lojavirtual.produto.domain.Produto;

public interface ProdutoRepository {
    Produto saveProduto(Produto produto);
}
