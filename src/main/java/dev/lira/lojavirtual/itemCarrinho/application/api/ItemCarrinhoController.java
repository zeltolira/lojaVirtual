package dev.lira.lojavirtual.itemCarrinho.application.api;

import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.service.ItemCarrinhoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoController implements ItemCarrinhoAPI {
    private final ItemCarrinhoService itemCarrinhoService;

    @Override
    public ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoController - postItemCarrinho");
        ItemCarrinhoResponse itemCarrinho = itemCarrinhoService.postItemCarrinho(itemCarrinhoRequest);
        log.info("[finish] ItemCarrinhoController - postItemCarrinho");
        return itemCarrinho;
    }

    @Override
    public void deletaItemCarrinho(Long idCarrinho, Long idItemCarrinho, UUID idProduto) {
        log.info("[start] ItemCarrinhoController - deletaItemCarrinho");
        itemCarrinhoService.deletaItemCarrinho(idCarrinho, idItemCarrinho, idProduto);
        log.info("[finish] ItemCarrinhoController - deletaItemCarrinho");
    }
}
