package Models;

import java.util.Objects;

/*
Elabore um código de cadastro de um produto com código, nome e quantidade
* */
public class Produto {

    private String codigo;
    private String nome;
    private float quantidade;

    public Produto(String codigo){
        this.codigo = codigo;
    }
    public Produto(String codigo, String nome, float quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(float quantidade) {
        this.quantidade += quantidade;
    }

    public void reduzirQuantidade(float quantidade) throws Exception {

        if (this.quantidade < quantidade) {
            throw new Exception("Quantidade inadequada");
        }

        this.quantidade -= quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {

        return String.join("\t", codigo, nome, Float.toString(quantidade));
    }

}
