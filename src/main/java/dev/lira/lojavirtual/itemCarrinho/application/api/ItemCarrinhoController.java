package dev.lira.lojavirtual.itemCarrinho.application.api;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.service.ItemCarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoController implements ItemCarrinhoAPI {
    private final ItemCarrinhoService itemCarrinhoService;

    @Override
    public ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoResponse - postItemCarrinho");
        ItemCarrinhoResponse itemCarrinho = itemCarrinhoService.postItemCarrinho(itemCarrinhoRequest);
        log.info("[finish] ItemCarrinhoResponse - postItemCarrinho");
        return itemCarrinho;
    }
}
