package dev.lira.lojavirtual.produto.promocao;

import java.math.BigDecimal;

public class DescontoLeveDoisPagueUm implements DescontoStrategy{
    @Override
    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade) {
        int quantidadePaga = (int) Math.ceil(quantidade / 2.0);
        return  preco.multiply(BigDecimal.valueOf(quantidadePaga));
    }
}
