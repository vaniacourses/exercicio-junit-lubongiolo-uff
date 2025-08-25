package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
        produto1 = new Produto("Tenis", 100.00);
        produto2 = new Produto("Camiseta", 50.00);
    }

    @Test
    @DisplayName("Testa adicionar um item no carrinho")
    public void testAdicionarItem() {
        carrinho.addItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(100.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Testa adicionar mltiplos itens no carrinho")
    public void testAdicionarMultiplosItens() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(150.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Testa remover um item do carrinho")
    public void testRemoverItem() throws ProdutoNaoEncontradoException {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.removeItem(produto1);
        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(50.00, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Testa remover um item inexistente do carrinho")
    public void testRemoverItemInexistente() {
        carrinho.addItem(produto1);
        Produto produto3 = new Produto("Meia", 25.00);
        assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(produto3));
    }

    @Test
    @DisplayName("Testa esvaziar o carrinho")
    public void testEsvaziarCarrinho() {
        carrinho.addItem(produto1);
        carrinho.addItem(produto2);
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal());
    }

    @Test
    @DisplayName("Testa o valor total de um carrinho vazio")
    public void testValorTotalCarrinhoVazio() {
        assertEquals(0.0, carrinho.getValorTotal());
    }
}
