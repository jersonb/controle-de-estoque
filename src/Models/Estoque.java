package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class Estoque extends ArrayList<Produto> {

    public Produto obterProdutoRegistrado(Produto produto){
        return this
                .stream()
                .filter(p -> p.equals(produto))
                .findAny()
                .orElse(null);

    }

    @Override
    public String toString() {
        var stringJoiner = new StringJoiner("\n");
        stringJoiner.add("Todos os produtos");
        stringJoiner.add(String.join("\t", Arrays.asList("Código", "Nome", "Quantidade")));
        this.forEach(p -> stringJoiner.add(p.toString()));
        return stringJoiner.toString();
    }

}
