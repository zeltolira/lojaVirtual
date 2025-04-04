package dev.lira.lojavirtual;


import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoDetalhadoReponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoListResponse;
import dev.lira.lojavirtual.produto.application.api.response.ProdutoResponse;
import dev.lira.lojavirtual.produto.application.repository.ProdutoRepository;
import dev.lira.lojavirtual.produto.application.service.ProdutoApplicationService;
import dev.lira.lojavirtual.produto.domain.Produto;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProdutoApplicationServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoApplicationService produtoApplicationService;

    private Produto produto;
    private UUID idProduto;

    @BeforeEach
    void setup(){
        idProduto = UUID.randomUUID();
        ProdutoRequest produtoRequest = new ProdutoRequest("Produto Teste", new BigDecimal("100.0"), TipoPromocao.SEM_PROMOCAO);
        produto = new Produto(produtoRequest);
    }

    @Test
    void deveCriarProdutoComSucesso(){
        ProdutoRequest produtoRequest = new ProdutoRequest("Produto Teste", new BigDecimal("100.0"), TipoPromocao.SEM_PROMOCAO);
        when(produtoRepository.saveProduto(any(Produto.class))).thenReturn(produto);

        ProdutoResponse produtoResponse = produtoApplicationService.postProduto(produtoRequest);

        assertNotNull(produtoResponse);
        verify(produtoRepository).saveProduto(any(Produto.class));
    }

    @Test
    void deveBuscarTodosProdutos(){
       //cenario
        when(produtoRepository.getAllProdutos()).thenReturn(List.of(produto));

        //açao
        List<ProdutoListResponse> produtos = produtoApplicationService.getAllProdutos();

        //verificacao
        assertEquals(1, produtos.size());
        verify(produtoRepository).getAllProdutos();
    }

    @Test
    void deveBuscarProdutoPorId(){
        //cenario

        when(produtoRepository.getProdutoById(idProduto)).thenReturn(produto);

        //acao
        ProdutoDetalhadoReponse produtoDetalhadoReponse = produtoApplicationService.getProdutoById(idProduto);

        //verificacao
      //  assertNull(produtoDetalhadoReponse);
        verify(produtoRepository).getProdutoById(idProduto);
    }

    @Test
    void deveAtualizarProduto(){
        //cenario
        ProdutoPatchRequest produtoPatchRequest = new ProdutoPatchRequest("Produto Atualizado", new BigDecimal("120.0"), StatusProduto.EM_ESTOQUE, TipoPromocao.SEM_PROMOCAO, LocalDateTime.now());
        when(produtoRepository.getProdutoById(idProduto)).thenReturn(produto);
        //acao
        produtoApplicationService.patchProdutoById(idProduto, produtoPatchRequest);
        //verificacao
        verify(produtoRepository).saveProduto(any(Produto.class));
    }

    @Test
    void deveAlterarStatusProdutoEmEstoque(){
        //cenario
        when(produtoRepository.getProdutoById(idProduto)).thenReturn(produto);
        //acao
        produtoApplicationService.alteraStatusProdutoParaEmEstoque(idProduto);
        //verificacao
        verify(produtoRepository).saveProduto(any(Produto.class));
    }

    @Test
    void deveAlterarStatusProdutoForaDeEstoque(){
        //cenario
        when(produtoRepository.getProdutoById(idProduto)).thenReturn(produto);
        //acao
        produtoApplicationService.alteraStatusProdutoParaForaDeEstoque(idProduto);
        //verificacao
        verify(produtoRepository).saveProduto(any(Produto.class));
    }

    @Test
    void deveDeletarProduto(){
        //cenario
        when(produtoRepository.getProdutoById(idProduto)).thenReturn(produto);
        //acao
        produtoApplicationService.deletaProduto(idProduto);
        //verificacao
        verify(produtoRepository).deletaProduto(produto);
    }
}
