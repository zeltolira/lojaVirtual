package dev.lira.lojavirtual;

import dev.lira.lojavirtual.produto.application.api.request.ProdutoRequest;
import dev.lira.lojavirtual.produto.domain.Produto;
import dev.lira.lojavirtual.produto.domain.StatusProduto;
import dev.lira.lojavirtual.produto.domain.TipoPromocao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void testCriacaoProduto(){
        ProdutoRequest produtoRequest = new ProdutoRequest();
        ReflectionTestUtils.setField(produtoRequest,"nomeProduto", "Produto Teste");
        ReflectionTestUtils.setField(produtoRequest, "precoProduto", new BigDecimal("100.00"));
        ReflectionTestUtils.setField(produtoRequest, "promocao", null);

        Produto produto = new Produto(produtoRequest);
        produto.setIdProduto(UUID.randomUUID());

        assertNotNull(produto.getIdProduto());
        assertEquals("Produto Teste", produto.getNomeProduto());
        assertEquals(new BigDecimal("100.00"), produto.getPrecoProduto());
        assertNull(produto.getPromocao());
        assertEquals(StatusProduto.EM_ESTOQUE, produto.getStatusProduto());
    }
}
