package dev.lira.lojavirtual.carrinho.infra;

import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.handler.APIException;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
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
    public Carrinho saveCarrinho(Carrinho carrinho) {
        log.info("[start] CarrinhoInfraRepository - saveCarrinho");
        Carrinho carrinhoSalvo = carrinhoSpringDataJPARepository.save(carrinho);
        log.info("[finish] CarrinhoInfraRepository - saveCarrinho");
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

    @Override
    public void deleteCarrinho(Carrinho carrinho) {
        log.info("[start] CarrinhoInfraRepository - delete");
        carrinhoSpringDataJPARepository.delete(carrinho);
        log.info("[finish] CarrinhoInfraRepository - delete");
    }

//    @Override
//    public void adicionaItemCarrinho(ItemCarrinho itemCarrinho) {
//        log.info("[start] CarrinhoInfraRepository - adicionaItemCarrinho");
//        Carrinho carrinho = itemCarrinho.getCarrinho();
//        carrinho.adicionarItem(itemCarrinho);
//        carrinhoSpringDataJPARepository.save(carrinho);
//        log.info("[finish] CarrinhoInfraRepository - adicionaItemCarrinho");
//
//    }
}
