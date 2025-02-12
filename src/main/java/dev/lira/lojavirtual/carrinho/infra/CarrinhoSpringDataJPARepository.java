package dev.lira.lojavirtual.carrinho.infra;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoSpringDataJPARepository extends JpaRepository <Carrinho, Long> {
}
