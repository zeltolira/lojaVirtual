package dev.lira.lojavirtual.produto.application.api.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoRequest {
    @NotBlank
    private String nomeProduto;
    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    private BigDecimal precoProduto;
    private StatusProduto statusProduto = StatusProduto.EM_ESTOQUE;
    @Enumerated(EnumType.STRING)
    private TipoPromocao promocao;
    private LocalDateTime dataHoraCriacao;

    public ProdutoRequest(String nomeProduto, BigDecimal precoProduto, TipoPromocao promocao) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.promocao = promocao;
    }
}