package dev.lira.lojavirtual.produto.domain;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import jakarta.persistence.*;
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
    private TipoPromocao promocao;

    public Produto(ProdutoRequest produtoRequest) {
        this.nomeProduto = produtoRequest.getNomeProduto();
        this.precoProduto = produtoRequest.getPrecoProduto();
        this.promocao = produtoRequest.getPromocao();
    }
}

