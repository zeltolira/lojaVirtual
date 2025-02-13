package dev.lira.lojavirtual.carrinho.application.api.response;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString
public class CarrinhoDetalhadoResponse {
    private Long idCarrinho;
    private List<ItemCarrinho> itens;
    private BigDecimal total;

    public CarrinhoDetalhadoResponse(Carrinho carrinho) {
        this.idCarrinho = carrinho.getIdCarrinho();
        this.itens = carrinho.getItens();
        this.total = carrinho.getTotal();
    }
}
