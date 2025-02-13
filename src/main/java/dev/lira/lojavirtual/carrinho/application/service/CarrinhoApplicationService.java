package dev.lira.lojavirtual.carrinho.application.service;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.handler.APIException;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        Carrinho carrinho = carrinhoRepository.postCarrinho(new Carrinho(carrinhoRequest));
        log.info("[finish] CarrinhoApplicationService - postCarrinho");
        return new CarrinhoResponse(carrinho);
    }

    @Override
    public CarrinhoDetalhadoResponse getCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoApplicationService - getCarrinhoById");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
        log.info("[finish] CarrinhoApplicationService - getCarrinhoById");
        return new CarrinhoDetalhadoResponse(carrinho);
    }

    @Override
    public ItemCarrinhoResponse adicionaItemCarrinho(Long idCarrinho, UUID idProduto, int quantidade) {
        log.info("[start] CarrinhoApplicationService - adicionaItemCarrinho");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
        if (carrinho == null){
            APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado");
        }
        Produto produto = produtoRepository.getProdutoById(idProduto);
        if (carrinho == null){
            APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        ItemCarrinho itemCarrinho = new ItemCarrinho(produto, quantidade);
        carrinho.adicionarItem(itemCarrinho);
        carrinhoRepository.adicionaItemCarrinho(itemCarrinho);
        log.info("[finish] CarrinhoApplicationService - adicionaItemCarrinho");
        return new ItemCarrinhoResponse(itemCarrinho);
    }

}
