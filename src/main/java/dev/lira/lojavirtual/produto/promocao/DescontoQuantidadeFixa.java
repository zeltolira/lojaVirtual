package dev.lira.lojavirtual.produto.promocao;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;

import java.math.BigDecimal;

public class DescontoQuantidadeFixa implements DescontoStrategy {
    private final int quantidadeGrupo;
    private final BigDecimal precoGrupo;
    private final TipoPromocao tipo;

    public DescontoQuantidadeFixa(int quantidadeGrupo, BigDecimal precoGrupo, TipoPromocao tipo) {
        this.quantidadeGrupo = quantidadeGrupo;
        this.precoGrupo = precoGrupo;
        this.tipo = tipo;
    }


    @Override
    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade) {
        int grupos = quantidade / quantidadeGrupo;
        int restantes =  quantidade % quantidadeGrupo;
        return precoGrupo.multiply(BigDecimal.valueOf(grupos))
                .add(preco.multiply(BigDecimal.valueOf(restantes)));
    }

    @Override
    public TipoPromocao getTipo() {
        return tipo;
    }
}
