package dev.lira.lojavirtual.itemCarrinho.application.api;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/item-carrinho")
public interface ItemCarrinhoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ItemCarrinhoResponse postItemCarrinho(@RequestBody @Valid ItemCarrinhoRequest itemCarrinhoRequest);
}
