package dev.lira.lojavirtual.produto.promocao;

import java.math.BigDecimal;

public interface DescontoStrategy {
    BigDecimal calcularDesconto(BigDecimal preco, int quantidade);
}
