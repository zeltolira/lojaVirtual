package dev.lira.lojavirtual.produto.application.api.request;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public class ProdutoRequest {
    @NotBlank
    private String nome;
    @NotNull(message = "O preço é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private TipoPromocao promocao;


}
