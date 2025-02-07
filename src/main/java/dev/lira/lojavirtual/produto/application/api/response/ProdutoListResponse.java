package dev.lira.lojavirtual.produto.application.api.response;

import dev.lira.lojavirtual.produto.domain.Produto;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class ProdutoListResponse {
    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    private StatusProduto statusProduto;
    private LocalDateTime dataHoraCriacao;

    public static List<ProdutoListResponse> converte(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoListResponse::new)
                .collect(Collectors.toList());
    }

    public ProdutoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nomeProduto = produto.getNomeProduto();
        this.precoProduto = produto.getPrecoProduto();
        this.statusProduto = produto.getStatusProduto();
        this.dataHoraCriacao = produto.getDataHoraCriacao();
    }
}
