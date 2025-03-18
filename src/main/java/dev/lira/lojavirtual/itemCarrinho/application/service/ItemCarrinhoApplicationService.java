package dev.lira.lojavirtual.itemCarrinho.application.service;

import dev.lira.lojavirtual.carrinho.domain.Carrinho;
import dev.lira.lojavirtual.carrinho.repository.CarrinhoRepository;
import dev.lira.lojavirtual.handler.APIException;
import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoPatchResquest;
import dev.lira.lojavirtual.itemCarrinho.application.api.request.ItemCarrinhoRequest;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoDetalhadoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.api.response.ItemCarrinhoResponse;
import dev.lira.lojavirtual.itemCarrinho.application.repository.ItemCarrinhoRepository;
import dev.lira.lojavirtual.itemCarrinho.domain.ItemCarrinho;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemCarrinhoApplicationService implements ItemCarrinhoService {
    private final ProdutoRepository produtoRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    @Override
    public ItemCarrinhoResponse postItemCarrinho(ItemCarrinhoRequest itemCarrinhoRequest) {
        log.info("[start] ItemCarrinhoApplicationService - postItemCarrinho");
        Produto produto = produtoRepository.getProdutoById(itemCarrinhoRequest.getIdProduto());
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(itemCarrinhoRequest.getIdCarrinho());
        ItemCarrinho itemCarrinho = new ItemCarrinho(produto, carrinho, itemCarrinhoRequest);
        ItemCarrinho itemSalvo = itemCarrinhoRepository.salvarItemCarrinho(itemCarrinho);
        carrinho.adicionarItem(itemCarrinho);
        carrinhoRepository.saveCarrinho(carrinho);
        log.info("[finish] ItemCarrinhoApplicationService - postItemCarrinho");
        return new ItemCarrinhoResponse(itemSalvo);
    }

    @Override
    public ItemCarrinhoDetalhadoResponse getItemCarrinho(Long idItemCarrinho) {
        log.info("[start] ItemCarrinhoApplicationService - getItemCarrinho");
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findByIdItemCarrinho(idItemCarrinho);
        log.info("[finish] ItemCarrinhoApplicationService - getItemCarrinho");
        return new ItemCarrinhoDetalhadoResponse(itemCarrinho);
    }

    @Override
    public void patchItemCarrinhoById(Long idCarrinho, UUID idProduto, ItemCarrinhoPatchResquest itemCarrinhoPatchResquest) {
        log.info("[start] ItemCarrinhoApplicationService - patchItemCarrinhoById");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
        if (carrinho == null){
            throw APIException.build(HttpStatus.NOT_FOUND, "Carrinho não encontrado para o id " + idCarrinho);
        }

        Optional<ItemCarrinho> itemCarrinhoOptional = carrinho.getItens().stream()
                        .filter(item -> item.getProduto().getIdProduto().equals(idProduto))
                        .findFirst();
        if (itemCarrinhoOptional.isEmpty()){
            throw APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado no carrinho");
        }
        ItemCarrinho itemCarrinho = itemCarrinhoOptional.get();

        int novaQuantidade = itemCarrinhoPatchResquest.getQuantidade();
        if (novaQuantidade < 0){
            throw APIException.build(HttpStatus.BAD_REQUEST,"A quantidade não poder ser negativa");
        }
        if (novaQuantidade == 0){
            carrinho.removerItem(itemCarrinho);
            itemCarrinhoRepository.delete(itemCarrinho);
            carrinhoRepository.saveCarrinho(carrinho);
        }else {
            itemCarrinho.setQuantidade(novaQuantidade);
            itemCarrinho.calcularSubtotal();
            carrinho.calcularTotal();
            itemCarrinhoRepository.salvarItemCarrinho(itemCarrinho);
            carrinhoRepository.saveCarrinho(carrinho);
        }
        log.info("[finish] ItemCarrinhoApplicationService - patchItemCarrinhoById");

    }

    @Override
    public void deletaItemCarrinho(Long idCarrinho, Long idItemCarrinho, UUID idProduto) {
        log.info("[start] ItemCarrinhoApplicationService - deletaItemCarrinho");
        Carrinho carrinho = carrinhoRepository.getCarrinhoById(idCarrinho);
        ItemCarrinho item = itemCarrinhoRepository.findByIdItemCarrinho(idItemCarrinho);
        if (!item.getCarrinho().getIdCarrinho().equals(idCarrinho)){
            throw new RuntimeException("O item não pertence ao carrinho especificado");
        }
        if (!item.getProduto().getIdProduto().equals(idProduto)){
            throw new RuntimeException("O item não está associado ao produto especificado");
        }
        carrinho.getItens().remove(item);
        itemCarrinhoRepository.delete(item);
        carrinho.calcularTotal();
        carrinhoRepository.saveCarrinho(carrinho);
        log.info("[finish] ItemCarrinhoApplicationService - deletaItemCarrinho");
    }

}
