package dev.lira.lojavirtual.produto.domain;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id_produto", updatable = false, unique = true, nullable = false)
    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal precoProduto;
    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusProduto statusProduto = StatusProduto.EM_ESTOQUE;
    @Enumerated(EnumType.STRING)
    private TipoPromocao promocao;

    public Produto(ProdutoRequest produtoRequest) {
        this.nomeProduto = produtoRequest.getNomeProduto();
        this.precoProduto = produtoRequest.getPrecoProduto();
        this.statusProduto = getStatusProduto();
        this.promocao = produtoRequest.getPromocao();
    }

    public void patchProduto(ProdutoPatchRequest produtoPatchRequest) {
        this.nomeProduto = produtoPatchRequest.getNomeProduto();
        this.precoProduto = produtoPatchRequest.getPrecoProduto();
        this.statusProduto = produtoPatchRequest.getStatusProduto();
        this.promocao = produtoPatchRequest.getPromocao();
    }
}

