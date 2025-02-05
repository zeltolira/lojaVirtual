package dev.lira.lojavirtual.produto.application.api;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoDetalhadoReponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoListResponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/produto")
public interface produtoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ProdutoResponse postProduto(@Valid @RequestBody ProdutoRequest produtoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ProdutoListResponse> getAllProdutos();

    @GetMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ProdutoDetalhadoReponse getProdutoById(@PathVariable UUID idProduto);

    @PatchMapping(value = "/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchProdutoById(@PathVariable UUID idProduto, @Valid @RequestBody ProdutoPatchRequest produtoPatchRequest);
}
