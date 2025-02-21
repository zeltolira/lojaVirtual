package dev.lira.lojavirtual.itemCarrinho.domain;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.produto.domain.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "itemCarrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemCarrinho;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private Carrinho carrinho;
    private int quantidade;
    private BigDecimal subtotal;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

       public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularSubtotal();
    }

       public ItemCarrinho(Produto produto, Carrinho carrinho, ItemCarrinhoRequest itemCarrinhoRequest) {
        this.produto = produto;
        this.carrinho = carrinho;
        this.quantidade = itemCarrinhoRequest.getQuantidade();
        this.dataHoraCriacao = LocalDateTime.now();
        calcularSubtotal();
    }


    public void calcularSubtotal(){
        if (produto.getPromocao() != null){
            this.subtotal = produto.getPromocao().calcularDesconto(produto.getPrecoProduto(), quantidade);
        }else {
            this.subtotal = produto.getPrecoProduto().multiply(BigDecimal.valueOf(quantidade));
        }
    }
}
