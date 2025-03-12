package dev.lira.lojavirtual.itemCarrinho.infra;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.handler.APIException;
import dev.lira.lojavirtual.itemCarrinho.application.repository.ItemCarrinhoRepository;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.Store;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoInfraRepository implements ItemCarrinhoRepository {
    private final ItemCarrinhoSpringDataJPARepository itemCarrinhoSpringDataJPARepository;
    private final ProdutoRepository produtoRepository;
    private final CarrinhoRepository carrinhoRepository;


    @Override
    public ItemCarrinho salvarItemCarrinho(ItemCarrinho itemCarrinho) {
        log.info("[start] ItemCarrinhoInfraRepository - salvarItemCarrinho");
        Produto produto = produtoRepository.getProdutoById(itemCarrinho.getProduto().getIdProduto());
        if (produto == null){
            throw APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(itemCarrinho.getCarrinho().getIdCarrinho());
        if (carrinho == null){
            throw APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado");
        }
        ItemCarrinho itemSalvo = itemCarrinhoSpringDataJPARepository.save(itemCarrinho);
        log.info("[finish] ItemCarrinhoInfraRepository - salvarItemCarrinho");
        return itemSalvo;
    }

    @Override
    public ItemCarrinho findById(Long idItemCarrinho) {
        ItemCarrinho itemCarrinho = itemCarrinhoSpringDataJPARepository.findById(idItemCarrinho)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND, "Item não encontrado para o id " + idItemCarrinho));
        return itemCarrinho;
    }

    @Override
    public void delete(ItemCarrinho item) {

    }
}
