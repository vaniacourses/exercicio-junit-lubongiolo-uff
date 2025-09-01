package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    public void testCarrinhoInicialmenteVazio() {
        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testAdicionarUmItem() {
        Produto produto = new Produto("Caneta", 2.5);
        carrinho.addItem(produto);

        assertEquals(1, carrinho.getQtdeItems());
        assertEquals(2.5, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testAdicionarMultiplosItens() {
        carrinho.addItem(new Produto("Lápis", 1.0));
        carrinho.addItem(new Produto("Borracha", 1.5));
        carrinho.addItem(new Produto("Caderno", 15.0));

        assertEquals(3, carrinho.getQtdeItems());
        assertEquals(17.5, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testRemoverItemExistente() throws ProdutoNaoEncontradoException {
        Produto produto = new Produto("Caderno", 15.0);
        carrinho.addItem(produto);

        carrinho.removeItem(produto);

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testRemoverItemInexistenteLancaExcecao() {
        Produto produto = new Produto("Item Inexistente", 99.0);

        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(produto);
        });
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.addItem(new Produto("Livro", 30.0));
        carrinho.addItem(new Produto("Caneta", 2.5));

        carrinho.esvazia();

        assertEquals(0, carrinho.getQtdeItems());
        assertEquals(0.0, carrinho.getValorTotal(), 0.001);
    }

    @Test
    public void testAdicionarProdutosComMesmoNome() {
        Produto p1 = new Produto("Livro", 30.0);
        Produto p2 = new Produto("Livro", 25.0); // Mesmo nome, preço diferente (mas equals trata como igual)

        carrinho.addItem(p1);
        carrinho.addItem(p2);

        assertEquals(2, carrinho.getQtdeItems());
        assertEquals(55.0, carrinho.getValorTotal(), 0.001);
    }
}
