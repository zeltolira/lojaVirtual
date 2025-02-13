package dev.lira.lojavirtual.itemCarrinho.application.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ItemCarrinhoRequest {
    @NotNull
    private Long idProduto;

    @NotNull
    private Long idCarrinho;

    @NotNull
    private int quantidade;
}
