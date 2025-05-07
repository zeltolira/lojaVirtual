package dev.lira.lojavirtual.simulacao;

import dev.lira.lojavirtual.produto.domain.TipoPromocao;

import java.math.BigDecimal;

public class SimuladorDePromocao {
    public static void main(String[] args) {
        BigDecimal precoUnitario = BigDecimal.valueOf(10.00); // Exemplo: produto custa R$5,00

        int[] quantidades = {1, 2, 3, 4, 5, 6,10};

        for (int qtd : quantidades) {
            System.out.println("Quantidade: " + qtd);
            for (TipoPromocao promocao : TipoPromocao.values()) {
                BigDecimal total = promocao.calcularDesconto(precoUnitario, qtd);
                System.out.printf("  %s: R$ %.2f%n", promocao.name(), total);
            }
            System.out.println();
        }
    }
}
