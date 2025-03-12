package dev.lira.lojavirtual.itemCarrinho.application.api;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/item-carrinho")
public interface ItemCarrinhoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ItemCarrinhoResponse postItemCarrinho(@RequestBody @Valid ItemCarrinhoRequest itemCarrinhoRequest);

    @GetMapping(value = "/{idItemCarrinho}")
    @ResponseStatus(code = HttpStatus.OK)
    ItemCarrinhoDetalhadoResponse getItemCarrinhoById(@PathVariable Long idItemCarrinho);

    @DeleteMapping(value = "/{idCarrinho}/{idItemCarrinho}/delete/{idProduto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaItemCarrinho(@PathVariable Long idCarrinho, @PathVariable Long idItemCarrinho, @PathVariable UUID idProduto);
}
