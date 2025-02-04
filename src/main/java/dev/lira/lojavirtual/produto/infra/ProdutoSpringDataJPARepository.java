package dev.lira.lojavirtual.produto.infra;

import dev.lira.lojavirtual.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoSpringDataJPARepository extends JpaRepository <Produto, UUID> {
}
