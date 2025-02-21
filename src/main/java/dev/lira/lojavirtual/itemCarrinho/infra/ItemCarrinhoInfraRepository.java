package dev.lira.lojavirtual.itemCarrinho.infra;

import dev.lira.lojavirtual.itemCarrinho.application.repository.ItemCarrinhoRepository;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
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
    public ItemCarrinho postItemCarrinho(ItemCarrinho itemCarrinho) {
        log.info("[start] ItemCarrinhoInfraRepository - postItemCarrinho");
        ItemCarrinho itemSalvo = itemCarrinhoSpringDataJPARepository.save(itemCarrinho);
        log.info("[finish] ItemCarrinhoInfraRepository - postItemCarrinho");
        return itemSalvo;
    }

    @Override
    public ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho) {
        return null;
    }
}
