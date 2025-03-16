package dev.lira.lojavirtual.produto.promocao;

import java.math.BigDecimal;

public class DescontoLeveDoisPagueUm implements DescontoStrategy{
    @Override
    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade) {
        int quantidadePaga = (quantidade + 1) /2;
        return  preco.multiply(BigDecimal.valueOf(quantidadePaga));
    }
}
