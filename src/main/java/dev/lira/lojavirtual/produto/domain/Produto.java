package dev.lira.lojavirtual.produto.domain;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Data
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
    @Column(name = "promocao")
    private TipoPromocao promocao;

    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAteracao;

    public Produto(ProdutoRequest produtoRequest) {
        this.nomeProduto = produtoRequest.getNomeProduto();
        this.precoProduto = produtoRequest.getPrecoProduto();
        this.statusProduto = produtoRequest.getStatusProduto();
        this.promocao = produtoRequest.getPromocao();
        this.dataHoraCriacao =  LocalDateTime.now();
    }



    public void patchProduto(ProdutoPatchRequest produtoRequest) {
        Optional.ofNullable(produtoRequest.getNomeProduto()).ifPresent(nome -> this.nomeProduto = nome);
        Optional.ofNullable(produtoRequest.getPrecoProduto()).ifPresent(preco -> this.precoProduto = preco);
        Optional.ofNullable(produtoRequest.getPromocao()).ifPresent(promocao -> this.promocao = promocao);
        this.dataHoraUltimaAteracao = LocalDateTime.now();
    }

    public void alteraStatusProdutoParaEmEstoque() {
        this.statusProduto = StatusProduto.EM_ESTOQUE;
    }

    public void alteraStatusProdutoParaForaDeEstoque() {
        this.statusProduto = StatusProduto.FORA_DE_ESTOQUE;
    }
}

