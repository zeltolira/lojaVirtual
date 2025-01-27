package dev.lira.lojavirtual.produto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@ToString
@Data
@Entity
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
    private UUID idPoduto;
    private String nome;
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private TipoPromocao promocao;

    public Produto(String nome, BigDecimal preco, TipoPromocao promocao) {
        this.nome = nome;
        this.preco = preco;
        this.promocao = promocao;
    }
}

