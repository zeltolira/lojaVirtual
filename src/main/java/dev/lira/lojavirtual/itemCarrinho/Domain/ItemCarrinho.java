package dev.lira.lojavirtual.itemCarrinho.Domain;

import dev.lira.lojavirtual.produto.domain.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
    private int quantidade;
    private BigDecimal subtotal;

    public void calcularSubtotal(){
        if (produto.getPromocao() != null){
            this.subtotal = produto.getPromocao().calcularDesconto(produto.getPrecoProduto(), quantidade);
        }else {
            this.subtotal = produto.getPrecoProduto().multiply(BigDecimal.valueOf(quantidade));
        }
    }
}
