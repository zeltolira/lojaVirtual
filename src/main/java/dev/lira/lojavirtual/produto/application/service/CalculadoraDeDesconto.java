package dev.lira.lojavirtual.produto.application.service;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import dev.lira.lojavirtual.produto.promocao.DescontoStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CalculadoraDeDesconto {
    private final Map<TipoPromocao, DescontoStrategy> estrategias;

    public CalculadoraDeDesconto(List<DescontoStrategy> strategies){
        this.estrategias = strategies.stream()
                .collect(Collectors.toMap(DescontoStrategy::getTipo, Function.identity()));
    }

    public BigDecimal calcular(TipoPromocao tipo, BigDecimal preco, int quantidade){
        if (tipo == TipoPromocao.SEM_PROMOCAO){
            return preco.multiply(BigDecimal.valueOf(quantidade));
        }

        DescontoStrategy estrategia = estrategias.get(tipo);
        if (estrategia == null || !estrategia.isAplicavel(quantidade)){
            return preco.multiply(BigDecimal.valueOf(quantidade));
        }
                return estrategia.calcularDesconto(preco, quantidade);
    }

}
