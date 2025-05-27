package dev.lira.lojavirtual.produto.promocao;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DescontoLeveDoisPagueUm implements DescontoStrategy{
    @Override
    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade) {
        int quantidadePaga = (int) Math.ceil(quantidade / 2.0);
        return  preco.multiply(BigDecimal.valueOf(quantidadePaga));
    }

    @Override
    public TipoPromocao getTipo() {
        return TipoPromocao.LEVE_2_PAGUE_1;
    }
}
