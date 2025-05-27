package dev.lira.lojavirtual.produto.promocao;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DescontoTresPorDez implements DescontoStrategy{
    @Override
    public BigDecimal calcularDesconto(BigDecimal preco, int quantidade) {
        int gruposDeTres = quantidade / 3;
        int restantes = quantidade % 3;
        return BigDecimal.valueOf(gruposDeTres * 10).add(preco.multiply(BigDecimal.valueOf(restantes)));
    }

    @Override
    public TipoPromocao getTipo() {
        return TipoPromocao.TRES_POR_DEZ;
    }

    @Override
    public boolean isAplicavel(int quantidade){
        return quantidade >= 3;
    }
}
