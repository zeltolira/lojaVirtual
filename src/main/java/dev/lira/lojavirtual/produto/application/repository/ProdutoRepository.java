package dev.lira.lojavirtual.produto.application.repository;

import dev.lira.lojavirtual.produto.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto saveProduto(Produto produto);
    List<Produto> getAllProdutos();
    Produto getProdutoById(UUID idProduto);
}
