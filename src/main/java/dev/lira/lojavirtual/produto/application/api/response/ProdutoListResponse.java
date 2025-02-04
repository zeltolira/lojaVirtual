package dev.lira.lojavirtual.produto.application.api.response;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ProdutoListResponse {
    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
}
