package dev.lira.lojavirtual.produto.application.api.response;

import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
public class ProdutoDetalhadoReponse {

    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;

    public ProdutoDetalhadoReponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.precoProduto = produto.getPrecoProduto();
    }
}
