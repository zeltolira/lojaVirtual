package dev.lira.lojavirtual.carrinho.application.service;

import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;
import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.handler.APIException;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CarrinhoApplicationService implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public CarrinhoResponse postCarrinho(CarrinhoRequest carrinhoRequest) {
        log.info("[start] CarrinhoApplicationService - postCarrinho");
        Carrinho carrinho = carrinhoRepository.saveCarrinho(new Carrinho(carrinhoRequest));
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
    public void deleleCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoApplicationService - deleleCarrinhoById");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
        if (!carrinho.getItens().isEmpty()){
            throw APIException.build(HttpStatus.NOT_FOUND, "Carrinho não pode ser excluído porque contém itens.");
        }
        carrinhoRepository.deleteCarrinho(carrinho);
        log.info("[finish] CarrinhoApplicationService - deleleCarrinhoById");

    }
}
