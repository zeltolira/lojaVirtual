package dev.lira.lojavirtual.produto.promocao;

import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
public class DescontoTresPorDez implements DescontoStrategy{
    @Override
    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade) {
        int gruposDeTres = quantidade / 3;
        int restantes = quantidade % 3;
        return BigDecimal.valueOf(gruposDeTres * 10).add(preco.multiply(BigDecimal.valueOf(restantes)));
    }
}
