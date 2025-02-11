package dev.lira.lojavirtual.itemCarrinho.application.api;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/itemCarrinho")
public interface ItemCarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ItemCarrinhoResponse adicionaItemCarrinho(@PathVariable UUID idProduto, @Valid @RequestBody ItemCarrinhoRequest itemCarrinhoRequest);
}
