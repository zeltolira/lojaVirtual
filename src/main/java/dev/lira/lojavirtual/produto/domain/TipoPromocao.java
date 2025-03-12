package dev.lira.lojavirtual.produto.domain;

import java.math.BigDecimal;

public enum TipoPromocao {
    LEVE_2_PAGUE_1, TRES_POR_DEZ;

    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade){
        switch (this){
            case LEVE_2_PAGUE_1:
                int quantidadePaga = (quantidade + 1) /2;
                return  preco.multiply(BigDecimal.valueOf(quantidadePaga));
            case TRES_POR_DEZ:
                int gruposDeTres = quantidade / 3;
                int restantes = quantidade % 3;
                return BigDecimal.valueOf(gruposDeTres * 10).add(preco.multiply(BigDecimal.valueOf(restantes)));
            default:
                return preco.multiply(BigDecimal.valueOf(quantidade));
        }
    }
}
