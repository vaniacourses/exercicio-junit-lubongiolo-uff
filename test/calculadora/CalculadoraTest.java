package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Teste de soma de dois números positivos")
    void testSomaPositivos() {
        assertEquals(5, calculadora.soma(2, 3));
    }

    @Test
    @DisplayName("Teste de soma com número negativo")
    void testSomaComNegativo() {
        assertEquals(0, calculadora.soma(2, -2));
    }

    @Test
    @DisplayName("Teste de subtração com resultado positivo")
    void testSubtracaoPositiva() {
        assertEquals(3, calculadora.subtracao(5, 2));
    }

    @Test
    @DisplayName("Teste de subtração com resultado negativo")
    void testSubtracaoNegativa() {
        assertEquals(-1, calculadora.subtracao(2, 3));
    }

    @Test
    @DisplayName("Teste de multiplicação de dois inteiros")
    void testMultiplicacao() {
        assertEquals(12, calculadora.multiplicacao(3, 4));
    }

    @Test
    @DisplayName("Teste de multiplicação por zero")
    void testMultiplicacaoPorZero() {
        assertEquals(0, calculadora.multiplicacao(5, 0));
    }

    @Test
    @DisplayName("Teste de divisão exata")
    void testDivisaoExata() {
        assertEquals(2, calculadora.divisao(10, 5));
    }

    @Test
    @DisplayName("Teste de divisão com resultado truncado")
    void testDivisaoTruncada() {
        assertEquals(2, calculadora.divisao(5, 2)); // 5/2 = 2.5 → int truncado para 2
    }

    @Test
    @DisplayName("Teste de divisão por zero")
    void testDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.divisao(10, 0));
    }

    @Test
    @DisplayName("Teste de somatória de número positivo")
    void testSomatoria() {
        assertEquals(15, calculadora.somatoria(5)); // 0 + 1 + 2 + 3 + 4 + 5 = 15
    }

    @Test
    @DisplayName("Teste de somatória de zero")
    void testSomatoriaZero() {
        assertEquals(0, calculadora.somatoria(0));
    }

    @Test
    @DisplayName("Teste de somatória com número negativo")
    void testSomatoriaNegativo() {
        assertEquals(0, calculadora.somatoria(-5));
    }

    @Test
    @DisplayName("Teste de número positivo")
    void testEhPositivoComPositivo() {
        assertTrue(calculadora.ehPositivo(10));
    }

    @Test
    @DisplayName("Teste de número zero como positivo")
    void testEhPositivoComZero() {
        assertTrue(calculadora.ehPositivo(0));
    }

    @Test
    @DisplayName("Teste de número negativo")
    void testEhPositivoComNegativo() {
        assertFalse(calculadora.ehPositivo(-1));
    }

    @Test
    @DisplayName("Teste de comparação: a == b")
    void testComparaIguais() {
        assertEquals(0, calculadora.compara(3, 3));
    }

    @Test
    @DisplayName("Teste de comparação: a > b")
    void testComparaMaior() {
        assertEquals(1, calculadora.compara(5, 2));
    }

    @Test
    @DisplayName("Teste de comparação: a < b")
    void testComparaMenor() {
        assertEquals(-1, calculadora.compara(2, 5));
    }
}
