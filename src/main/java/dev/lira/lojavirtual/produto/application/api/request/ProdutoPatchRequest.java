package dev.lira.lojavirtual.produto.application.api.request;

import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class ProdutoPatchRequest {
    @NotNull
    private String nomeProduto;
    @NotNull
    private BigDecimal precoProduto;
    private StatusProduto statusProduto;
    @NotNull
    private TipoPromocao promocao;
    private LocalDateTime dataHoraUltimaAteracao;

    public ProdutoPatchRequest(String nomeProduto, BigDecimal precoProduto, StatusProduto statusProduto, TipoPromocao promocao, LocalDateTime dataHoraUltimaAteracao) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.statusProduto = statusProduto;
        this.promocao = promocao;
        this.dataHoraUltimaAteracao = LocalDateTime.now();
    }
}
