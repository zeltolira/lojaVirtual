package dev.lira.lojavirtual.carrinho.application.service;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

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

        log.info("[finish] CarrinhoApplicationService - getCarrinhoById");
        return null;
    }

    @Override
    public ItemCarrinhoResponse adicionaItemCarrinho(Long idCarrinho, UUID idProduto, int quantidade) {
        log.info("[start] CarrinhoApplicationService - adicionaItemCarrinho");

        log.info("[finish] CarrinhoApplicationService - adicionaItemCarrinho");
        return null;
    }

}
