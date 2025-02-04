package dev.lira.lojavirtual.produto.infra;

import dev.lira.lojavirtual.handler.APIException;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Produto> getAllProdutos() {
        log.info("[start] ProdutoInfraRepository - getAllProdutos");
        List<Produto> todosProdutos = produtoSpringDataJPARepository.findAll();
        log.info("[finish] ProdutoInfraRepository - getAllProdutos");
        return todosProdutos;
    }

    @Override
    public Produto getProdutoById(UUID idProduto) {
        log.info("[start] ProdutoInfraRepository - getProdutoById");
        Produto produto = produtoSpringDataJPARepository.findById(idProduto)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Produto Não encontrado para o idProduto fornecido " + idProduto));
        log.info("[finish] ProdutoInfraRepository - getProdutoById");
        return produto;
    }
}
