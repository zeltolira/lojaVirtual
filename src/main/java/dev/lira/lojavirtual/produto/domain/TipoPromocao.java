package dev.lira.lojavirtual.produto.domain;

import dev.lira.lojavirtual.produto.promocao.DescontoLeveDoisPagueUm;
import dev.lira.lojavirtual.produto.promocao.DescontoStrategy;
import dev.lira.lojavirtual.produto.promocao.DescontoTresPorDez;

import java.math.BigDecimal;

public enum TipoPromocao {
    LEVE_2_PAGUE_1(new DescontoLeveDoisPagueUm()),
    TRES_POR_DEZ(new DescontoTresPorDez());

    private final DescontoStrategy descontoStrategy;

    TipoPromocao(DescontoStrategy descontoStrategy){
        this.descontoStrategy = descontoStrategy;
    }

    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade){
        if (this.descontoStrategy == null){
            return preco.multiply(BigDecimal.valueOf((quantidade)));
        }
        return descontoStrategy.calcularDesconto(preco, quantidade);
    }

//    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade){
//        if (this == null){
//            return preco.multiply(BigDecimal.valueOf((quantidade)));
//        }
//        switch (this){
//            case LEVE_2_PAGUE_1:
//                int quantidadePaga = (quantidade + 1) /2;
//                return  preco.multiply(BigDecimal.valueOf(quantidadePaga));
//            case TRES_POR_DEZ:
//                int gruposDeTres = quantidade / 3;
//                int restantes = quantidade % 3;
//                return BigDecimal.valueOf(gruposDeTres * 10).add(preco.multiply(BigDecimal.valueOf(restantes)));
//            default:
//                return preco.multiply(BigDecimal.valueOf(quantidade));
//
//        }
//    }

}
