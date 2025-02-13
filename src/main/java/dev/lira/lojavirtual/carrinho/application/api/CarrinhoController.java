package dev.lira.lojavirtual.carrinho.application.api;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CarrinhoController implements CarrinhoAPI {
    private final CarrinhoService carrinhoService;

    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoController - postCarrinho");
        CarrinhoResponse carrinho = carrinhoService.postCarrinho(carrinhoRequest);
        log.info("[finish] CarrinhoController - postCarrinho");
        return carrinho;
    }

    @Override
    public CarrinhoDetalhadoResponse getCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoController - getCarrinhoById");
        CarrinhoDetalhadoResponse carrinhoDetalhado = carrinhoService.getCarrinhoById(idCarrinho);
        log.info("[finish] CarrinhoController - getCarrinhoById");
        return carrinhoDetalhado;
    }

    @Override
    public ItemCarrinhoResponse adicionaItemCarrinho(Long idCarrinho, UUID idProduto, int quantidade) {
        log.info("[start] CarrinhoController - adicionaItemCarrinho");
        ItemCarrinhoResponse adicionaItem = carrinhoService.adicionaItemCarrinho(idCarrinho, idProduto, quantidade);
        log.info("[finish] CarrinhoController - adicionaItemCarrinho");
        return adicionaItem;
    }

}
