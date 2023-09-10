import Models.ControleDeEstoque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class ControleDeEstoqueTests {

    @Test
    public void deve_registrar_compra() {
        var controleDeEstoque = new ControleDeEstoque();

        var codigo = UUID.randomUUID().toString();
        controleDeEstoque.comprar(codigo, codigo, 1);

        var relatorio = controleDeEstoque.gerarRelatorio();
        System.out.println(relatorio);
        Assertions.assertTrue(relatorio.contains(codigo));
    }

    @Test
    public void deve_aumentar_quantidade_quando_o_produto_existe() {
        var controleDeEstoque = new ControleDeEstoque();

        var codigo = UUID.randomUUID().toString();
        controleDeEstoque.comprar(codigo, codigo, 1);
        controleDeEstoque.comprar(codigo, codigo, 1);

        var relatorio = controleDeEstoque.gerarRelatorio();
        System.out.println(relatorio);
        Assertions.assertTrue(relatorio.endsWith("2.0"));
    }

    @Test
    public void deve_lancar_erro_se_a_quantidade_de_venda_maior_que_estoque()  {
        var controleDeEstoque = new ControleDeEstoque();

        var codigo = UUID.randomUUID().toString();
        controleDeEstoque.comprar(codigo, codigo, 1);
        controleDeEstoque.comprar(codigo, codigo, 1);
        Assertions.assertThrows(Exception.class, () -> controleDeEstoque.vender(codigo,  3));
    }

    @Test
    public void deve_realizar_venda()  {
        var controleDeEstoque = new ControleDeEstoque();

        var codigo = UUID.randomUUID().toString();
        controleDeEstoque.comprar(codigo, codigo, 1);
        controleDeEstoque.comprar(codigo, codigo, 1);
        controleDeEstoque.comprar(codigo, codigo, 1);
        Assertions.assertDoesNotThrow(() -> controleDeEstoque.vender(codigo, 3));

        var relatorio = controleDeEstoque.gerarRelatorio();
        System.out.println(relatorio);
        Assertions.assertTrue(relatorio.endsWith("0.0"));
    }


}
