package dev.lira.lojavirtual.produto.application.api;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoDetalhadoReponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoListResponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;
import dev.lira.lojavirtual.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@Log4j2
@RequiredArgsConstructor
public class ProdutoController implements ProdutoAPI {
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

    @Override
    public ProdutoDetalhadoReponse getProdutoById(UUID idProduto) {
        log.info("[start] ProdutoController - getProdutoById");
        ProdutoDetalhadoReponse produtoDetalhado = produtoService.getProdutoById(idProduto);
        log.info("[finish] ProdutoController - getProdutoById");
        return produtoDetalhado;
    }

    @Override
    public void patchProdutoById(UUID idProduto, ProdutoPatchRequest produtoPatchRequest) {
        log.info("[start] ProdutoController - patchProdutoById");
        log.info("[idProduto] {}", idProduto);
        produtoService.patchProdutoById(idProduto, produtoPatchRequest);
        log.info("[finish] ProdutoController - patchProdutoById");

    }

    @Override
    public void alteraStatusProdutoParaEmEstoque(UUID idProduto) {
        log.info("[start] ProdutoController - alteraStatusProdutoParaEmEstoque");
        log.info("[idProduto] {}", idProduto);
        produtoService.alteraStatusProdutoParaEmEstoque(idProduto);
        log.info("[finish] ProdutoController - alteraStatusProdutoParaEmEstoque");

    }

    @Override
    public void alteraStatusProdutoParaForaDeEstoque(UUID idProduto) {
        log.info("[start] ProdutoController - alteraStatusProdutoParaForaDeEstoque");
        log.info("[idProduto] {}", idProduto);
        produtoService.alteraStatusProdutoParaForaDeEstoque(idProduto);
        log.info("[start] ProdutoController - alteraStatusProdutoParaForaDeEstoque");

    }

    @Override
    public void deletaProduto(UUID idProduto) {
        log.info("[start] ProdutoController - deletaProduto");
        log.info("[idProduto] {}", idProduto);
        produtoService.deletaProduto(idProduto);
        log.info("[finish] ProdutoController - deletaProduto");

    }
}
