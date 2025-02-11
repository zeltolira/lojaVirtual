package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.repository.ItemCarrinhoRepository;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoApplicationService implements ItemCarrinhoService {
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public ItemCarrinhoResponse adicionaItemCarrinho(UUID idProduto, ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoApplicationService - adicionaItemCarrinho");
        Produto produto = produtoRepository.getProdutoById(idProduto);
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.saveItemCarrinho(new ItemCarrinho(produto, itemCarrinhoRequest));
        log.info("[finish] ItemCarrinhoApplicationService - adicionaItemCarrinho");
        return new ItemCarrinhoResponse(itemCarrinho);
    }
}
