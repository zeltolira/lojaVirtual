package dev.lira.lojavirtual.produto.domain;

import dev.lira.lojavirtual.produto.promocao.DescontoLeveDoisPagueUm;
import dev.lira.lojavirtual.produto.promocao.DescontoStrategy;
import dev.lira.lojavirtual.produto.promocao.DescontoTresPorDez;

import java.math.BigDecimal;

public enum TipoPromocao {
    SEM_PROMOCAO,
    LEVE_2_PAGUE_1,
    TRES_POR_DEZ
}
