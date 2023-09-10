import Models.ControleDeEstoque;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/*
 * Elabore um código de cadastro de um produto com código, nome e quantidade (todos a serem cadastrados pelo teclado)
 * Em seguida, informe na tela que todos foram cadastrados com sucesso e pergunte ao usuário se ele deseja
 * realizar uma venda para decrementar a quantidade de produtos informado anteriormente.
 * Se ele desejar realizar a operação, digitar 1. Se ele não quiser, digitar 0 (faça Isso usando switch)
 *
 * Para a opção 1, o sistema deve perguntar quantos ele vai vender e capturar esse valor com o teclado.
 * Em seguida, o sistema deve chamar um método que calcule o decremento do estoque.
 * Após a operação, informe a quantidade atual do estoque na tela.
 *
 * Para a opção 0, o sistema exibe uma mensagem de "encerrando o programa"
 *
 * OBSERVAÇÃO: Realize esse código utilizando os conceitos de métodos e modificadores de acesso.
 *
 * */
public class Main {
    static ControleDeEstoque controleDeEstoque;

    public static void main(String[] args) {
        controleDeEstoque = new ControleDeEstoque();

        exibirMenuPrincipal();

    }

    private static void exibirMenuPrincipal() {
        var opcao = obterOpcaoDoMenuPrincipal();

        switch (opcao) {
            case "1" -> comprarProduto();
            case "2" -> venderProduto();
            case "3" -> gerarRelatorio();
            default -> System.out.println("Volte Sempre!");
        }
    }


    private static void gerarRelatorio() {

        System.out.println("\n\n");
        System.out.println(controleDeEstoque.gerarRelatorio());
        System.out.println("\n\n");

        exibirMenuPrincipal();
    }

    private static void venderProduto() {

        boolean continuar;
        do {
            var scanner = new Scanner(System.in);
            System.out.println(controleDeEstoque.gerarRelatorio());

            System.out.println("Informe o código do do produto que deseja vender");
            var codigo = scanner.nextLine();

            System.out.println("Informe a quantidade que deseja vender");
            var quantidade = scanner.nextLine();
            try {

                controleDeEstoque.vender(codigo, Float.parseFloat(quantidade));
                System.out.println("Produto vendido com sucesso");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


            System.out.println("Deseja continuar vendendo? [S/n]");
            continuar = scanner.nextLine().trim().toLowerCase().startsWith("n");

        } while (!continuar);

        exibirMenuPrincipal();
    }

    private static void comprarProduto() {

        boolean continuar;

        do {
            var scanner = new Scanner(System.in);

            System.out.println("Informe o código do produto:");
            var codigo = scanner.nextLine();
            System.out.println("Informe o nome do produto:");
            var nome = scanner.nextLine();
            System.out.println("Informe a quantidade do produto:");
            var quantidade = scanner.nextLine();

            controleDeEstoque.comprar(codigo, nome, Float.parseFloat(quantidade));
            System.out.println("Produto cadastrado com sucesso");
            System.out.println("deseja cadastrar mais um produto? [S/n]");
            continuar = scanner.nextLine().trim().toLowerCase().startsWith("n");
        } while (!continuar);

        exibirMenuPrincipal();
    }

    private static String obterOpcaoDoMenuPrincipal() {

        var stringJoined = new StringJoiner("\n");

        stringJoined.add("");
        stringJoined.add("Informe a opção desejada:");
        stringJoined.add("");
        stringJoined.add("1 - Comprar produto");
        stringJoined.add("2 - Vender produto");
        stringJoined.add("3 - Gerar relatório de estoque");
        stringJoined.add("0 - Sair");
        stringJoined.add("");

        System.out.printf(stringJoined.toString());

        var scanner = new Scanner(System.in);

        var opcao = scanner.nextLine();

        var opcoesValidas = Arrays.asList("0", "1", "2", "3");

        if (!opcoesValidas.contains(opcao)) {
            System.out.println("Opção inválida.");
            obterOpcaoDoMenuPrincipal();
        }

        return opcao;

    }
}