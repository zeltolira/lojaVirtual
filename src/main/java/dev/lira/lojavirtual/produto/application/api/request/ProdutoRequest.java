package dev.lira.lojavirtual.produto.application.api.request;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ProdutoRequest {
    private UUID idPoduto;
    @NotBlank
    private String nome;
    @NotBlank
    private BigDecimal preco;
    @NotNull
    private TipoPromocao promocao;
}
