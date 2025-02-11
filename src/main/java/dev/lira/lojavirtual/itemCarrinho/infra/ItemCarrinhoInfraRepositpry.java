package dev.lira.lojavirtual.itemCarrinho.infra;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.repository.ItemCarrinhoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoInfraRepository implements ItemCarrinhoRepository {
    private final ItemCarrinhoSpringDataJPARepository itemCarrinhoSpringDataJPARepository;

    @Override
    public ItemCarrinhoResponse saveItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoInfraRepository - saveItemCarrinho");
        itemCarrinhoSpringDataJPARepository.save(itemCarrinhoRequest);
        log.info("[start] ItemCarrinhoInfraRepository - saveItemCarrinho");
        return null;
    }
}