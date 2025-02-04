package dev.lira.lojavirtual.produto.application.api.response;

import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class ProdutoResponse {

    private UUID idProduto;

    public ProdutoResponse(Produto produto) {
       this.idProduto = produto.getIdProduto();
    }
}
