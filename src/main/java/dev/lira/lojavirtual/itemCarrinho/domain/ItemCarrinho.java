package dev.lira.lojavirtual.itemCarrinho.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.produto.domain.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Log4j2
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
    @JsonIgnore
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
        this.setQuantidade(itemCarrinhoRequest.getQuantidade());
        calcularSubtotal();
    }



    public void calcularSubtotal() {
       if (produto == null){
           throw new IllegalArgumentException("O produto não pode ser nulo ao calcular o subtotal.");
       }
       if (produto.getPrecoProduto() == null){
           throw new IllegalArgumentException("O preço do produto não pode ser nulo.");
       }

        log.info("Calculando subtotal para o produto [{}]: Preço = {}, Quantidade = {}",
                produto.getIdProduto(), produto.getPrecoProduto(), quantidade);

        if (produto.getPromocao() != null) {
            this.subtotal = produto.getPromocao().calcularDesconto(produto.getPrecoProduto(), quantidade);
            log.info("Promoção aplicada: {} | Subtotal calculado: {}", produto.getPromocao(), subtotal);
        } else {
            this.subtotal = produto.getPrecoProduto().multiply(BigDecimal.valueOf(quantidade));
            log.info("Nenhuma promoção aplicada | Subtotal calculado: {}", subtotal);
        }
    }


    public void setQuantidade(int quantidade){
            if (quantidade <= 0){
                throw new IllegalArgumentException("Quantidade deve ser maior que zero");
            }
            this.quantidade = quantidade;
            calcularSubtotal();
    }
}

