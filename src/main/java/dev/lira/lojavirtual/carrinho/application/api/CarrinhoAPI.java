package dev.lira.lojavirtual.carrinho.application.api;

import dev.lira.lojavirtual.carrinho.application.api.response.CarrinhoResponse;
import dev.lira.lojavirtual.carrinho.application.request.CarrinhoRequest;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/carrinho")
public interface CarrinhoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CarrinhoResponse postCarrinho(@Valid @RequestBody CarrinhoRequest carrinhoRequest);
}
