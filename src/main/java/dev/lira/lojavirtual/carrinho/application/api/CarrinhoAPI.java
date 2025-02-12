package dev.lira.lojavirtual.carrinho.application.api;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.api.request.CarrinhoRequest;
import dev.lira.lojavirtual.carrinho.application.api.response.ItemCarrinhoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCarrinho(@Valid @RequestBody CarrinhoRequest carrinhoRequest);

    @PostMapping(value = "/{idCarrinho}/itens/{idProduto}")
    @ResponseStatus(code = HttpStatus.OK)
    ItemCarrinhoResponse adicionaItemCarrinho(@PathVariable(name = "idCarrinho") Long idCarrinho,
                                              @PathVariable(name = "idProduto") UUID idProduto,
                                              @RequestParam int quantidade);
}
