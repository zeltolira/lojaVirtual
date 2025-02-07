package dev.lira.lojavirtual.produto.application.api.response;

import dev.lira.lojavirtual.produto.domain.Produto;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString
public class ProdutoResponse {

    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    private StatusProduto statusProduto;
    private LocalDateTime dataHoraCriacao;

    public ProdutoResponse(Produto produto) {
       this.idProduto = produto.getIdProduto();
       this.nomeProduto = produto.getNomeProduto();
       this.precoProduto = produto.getPrecoProduto();
       this.statusProduto = produto.getStatusProduto();
       this.dataHoraCriacao = produto.getDataHoraCriacao();
    }
}
