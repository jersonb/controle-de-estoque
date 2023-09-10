package Models;

public class ControleDeEstoque {
    private Estoque estoque;

    public ControleDeEstoque() {
        estoque = new Estoque();
    }

    public void comprar(String codigoProduto, String nomeProduto, float quantidadeProduto) {
        var produto = new Produto(codigoProduto, nomeProduto, quantidadeProduto);

        var produtoJaRegistrado = estoque.obterProdutoRegistrado(produto);

        if (produtoJaRegistrado == null) {
            estoque.add(produto);
        } else {
            produtoJaRegistrado.adicionarQuantidade(quantidadeProduto);
        }
    }

    public void vender(String codigoProduto, float quantidadeProduto) throws Exception {
        var produto = new Produto(codigoProduto);

        var produtoRegistrado = estoque.obterProdutoRegistrado(produto);

        produtoRegistrado.reduzirQuantidade(quantidadeProduto);

    }

    public String gerarRelatorio() {
        return estoque.toString();
    }
}
