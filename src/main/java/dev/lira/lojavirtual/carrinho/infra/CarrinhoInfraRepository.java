package dev.lira.lojavirtual.carrinho.infra;

import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CarrinhoInfraRepository implements CarrinhoRepository {
    private final CarrinhoSpringDataJPARepository carrinhoSpringDataJPARepository;

    @Override
    public Carrinho postCarrinho(Carrinho carrinho) {
        log.info("[start] CarrinhoInfraRepository - postCarrinho");
        Carrinho carrinhoSalvo = carrinhoSpringDataJPARepository.save(carrinho);
        log.info("[finish] CarrinhoInfraRepository - postCarrinho");
        return carrinhoSalvo;
    }

    @Override
    public Carrinho getCarrinhoById(Long idCarrinho) {
        log.info("[start] CarrinhoInfraRepository - carrinhogetCarrinhoById");
        Carrinho carrinho = carrinhoSpringDataJPARepository.findById(idCarrinho)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encotrado para o ID " + idCarrinho));
        log.info("[finish] CarrinhoInfraRepository - carrinhogetCarrinhoById");
        return carrinho;
    }
}
