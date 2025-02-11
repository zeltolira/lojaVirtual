package dev.lira.lojavirtual.carrinho.domain;

import dev.lira.lojavirtual.carrinho.application.request.CarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrinho;
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrinho> itens = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Carrinho(CarrinhoRequest carrinhoRequest) {
        this.itens = carrinhoRequest.getItens();
        this.total = carrinhoRequest.getTotal();
        this.dataHoraCriacao = LocalDateTime.now();
    }


    public void adicionarItem(ItemCarrinho item){
        itens.add(item);
        item.setCarrinho(this);
        calcularTotal();
    }

    public  void removerItem(ItemCarrinho item){
        itens.remove(item);
        calcularTotal();
    }
    private void calcularTotal() {
        this.total = itens.stream()
                .map(ItemCarrinho::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
