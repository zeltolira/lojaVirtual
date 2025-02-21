package dev.lira.lojavirtual.itemCarrinho.infra;

import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoSpringDataJPARepository extends JpaRepository <ItemCarrinho, Long> {
}
