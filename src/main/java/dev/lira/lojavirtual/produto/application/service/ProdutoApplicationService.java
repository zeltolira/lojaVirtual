package dev.lira.lojavirtual.produto.application.service;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService {

    private final ProdutoRepository produtoRespository;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - postProduto");
        Produto produto = produtoRespository.saveProduto(new Produto(produtoRequest));
        log.info("[finish] ProdutoApplicationService - postProduto");
        return new ProdutoResponse(produto);
    }
}
