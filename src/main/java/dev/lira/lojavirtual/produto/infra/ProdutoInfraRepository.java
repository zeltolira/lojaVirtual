package dev.lira.lojavirtual.produto.infra;

import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ProdutoInfraRepository implements ProdutoRepository {

    private final ProdutoSpringDataJPARepository produtoSpringDataJPARepository;

    @Override
    public Produto saveProduto(Produto produto) {
        log.info("[start] ProdutoInfraRepository - saveProduto");
        produtoSpringDataJPARepository.save(produto);
        log.info("[finish] ProdutoInfraRepository - saveProduto");
        return produto;
    }
}
