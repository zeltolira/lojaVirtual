package dev.lira.lojavirtual.produto.promocao;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;

import java.math.BigDecimal;

public interface DescontoStrategy {
    BigDecimal calcularDesconto(BigDecimal preco, int quantidade);
    TipoPromocao getTipo();
    default boolean isAplicavel(int quantidade){
        return true;
    }
}
