package dev.lira.lojavirtual;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoPatchRequest;
import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.domain.Produto;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {
    private Produto produto;

    @BeforeEach
    void setUp() {
        ProdutoRequest request = new ProdutoRequest("Produto Teste", new BigDecimal("100.00"), TipoPromocao.SEM_PROMOCAO);
        produto = new Produto(request);
    }

    @Test
    void testCriacaoProduto() {
//        assertNotNull(produto.getIdProduto());
        assertEquals("Produto Teste", produto.getNomeProduto());
        assertEquals(new BigDecimal("100.00"), produto.getPrecoProduto());
        assertEquals(StatusProduto.EM_ESTOQUE, produto.getStatusProduto());
        assertEquals(TipoPromocao.SEM_PROMOCAO, produto.getPromocao());
    }

    @Test
    void deveAlterarStatusParaEmEstoque(){
        Produto produto = new Produto(new ProdutoRequest("Produto Teste", BigDecimal.TEN, null));

        produto.alteraStatusProdutoParaEmEstoque();

        assertEquals(StatusProduto.EM_ESTOQUE, produto.getStatusProduto());
    }
    @Test
    void testPatchProduto() {
        ProdutoPatchRequest patchRequest = new ProdutoPatchRequest("Novo Nome", new BigDecimal("120.00"), StatusProduto.EM_ESTOQUE, TipoPromocao.LEVE_2_PAGUE_1, LocalDateTime.now());
        produto.patchProduto(patchRequest);

        assertEquals("Novo Nome", produto.getNomeProduto());
        assertEquals(new BigDecimal("120.00"), produto.getPrecoProduto());
        assertEquals(TipoPromocao.LEVE_2_PAGUE_1, produto.getPromocao());
    }

    @Test
    void testAlteraStatusProduto() {
        produto.alteraStatusProdutoParaForaDeEstoque();
        assertEquals(StatusProduto.FORA_DE_ESTOQUE, produto.getStatusProduto());
    }

    @Test
    void testCalculoDescontoSemPromocao() {
        BigDecimal total = produto.getPromocao().calcularDesconto(new BigDecimal("50.00"), 3);
        assertEquals(new BigDecimal("150.00"), total);
    }

}
