package dev.lira.lojavirtual;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.domain.Produto;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdutoTest {
    private Produto produto;

    @BeforeEach
    void setUp() {
        ProdutoRequest request = new ProdutoRequest("Produto Teste", new BigDecimal("100.00"), TipoPromocao.SEM_PROMOCAO);
        produto = new Produto(request);
    }

    @Test
    void testCriacaoProduto() {
        assertNotNull(produto.getIdProduto());
        assertEquals("Produto Teste", produto.getNomeProduto());
        assertEquals(new BigDecimal("100.00"), produto.getPrecoProduto());
        assertEquals(StatusProduto.EM_ESTOQUE, produto.getStatusProduto());
        assertEquals(TipoPromocao.SEM_PROMOCAO, produto.getPromocao());
    }

    @Test
    void deveAlterarStatusPAraEmEstoque(){
        Produto produto = new Produto(new ProdutoRequest("Produto Teste", BigDecimal.TEN, null));

        produto.alteraStatusProdutoParaEmEstoque();

        assertEquals(StatusProduto.EM_ESTOQUE, produto.getStatusProduto());
    }
}
