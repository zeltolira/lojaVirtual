package dev.lira.lojavirtual.produto.application.api;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoListResponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;
import dev.lira.lojavirtual.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
public class ProdutoController implements produtoAPI {
    private final ProdutoService produtoService;

    @Override
    public ProdutoResponse postProduto(ProdutoRequest produtoRequest) {
        log.info("[start] ProdutoController - postProduto");
        ProdutoResponse produtoCriado = produtoService.postProduto(produtoRequest);
        log.info("[finish] ProdutoController - postProduto");
        return produtoCriado;
    }

    @Override
    public List<ProdutoListResponse> getAllProdutos() {
        log.info("[start] ProdutoController - getAllProdutos");
        List<ProdutoListResponse> produtos = produtoService.getAllProdutos();
        log.info("[finish] ProdutoController - getAllProdutos");
        return produtos;
    }
}
