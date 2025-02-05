package dev.lira.lojavirtual.produto.application.api.request;

import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ProdutoPatchRequest {
    private String nomeProduto;
    private BigDecimal precoProduto;
    private StatusProduto statusProduto;
    private TipoPromocao promocao;
}
