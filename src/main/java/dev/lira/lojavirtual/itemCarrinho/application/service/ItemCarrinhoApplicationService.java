package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.repository.ItemCarrinhoRepository;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoApplicationService implements ItemCarrinhoService {
    private final ProdutoRepository produtoRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    @Override
    public ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoApplicationService - postItemCarrinho");
        Produto produto = produtoRepository.getProdutoById(itemCarrinhoRequest.getIdProduto());
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(itemCarrinhoRequest.getIdCarrinho());
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.postItemCarrinho(new ItemCarrinho(produto, carrinho, itemCarrinhoRequest));
        ItemCarrinho itemSalvo = itemCarrinhoRepository.salvarItemCarrinho(itemCarrinho);
        log.info("[finish] ItemCarrinhoApplicationService - postItemCarrinho");
        return new ItemCarrinhoResponse(itemCarrinho);
    }

}
