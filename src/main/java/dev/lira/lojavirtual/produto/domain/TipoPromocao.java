package dev.lira.lojavirtual.produto.domain;

import dev.lira.lojavirtual.produto.promocao.DescontoLeveDoisPagueUm;
import dev.lira.lojavirtual.produto.promocao.DescontoStrategy;
import dev.lira.lojavirtual.produto.promocao.DescontoTresPorDez;

import java.math.BigDecimal;

public enum TipoPromocao {
    SEM_PROMOCAO(null),
    LEVE_2_PAGUE_1(new DescontoLeveDoisPagueUm()),
    TRES_POR_DEZ(new DescontoTresPorDez());

    private final DescontoStrategy descontoStrategy;

    TipoPromocao(DescontoStrategy descontoStrategy){
        this.descontoStrategy = descontoStrategy;
    }

    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade){
        return descontoStrategy != null
                ? descontoStrategy.calcularDesconto(preco, quantidade)
                : preco.multiply(BigDecimal.valueOf(quantidade));
    }
}
