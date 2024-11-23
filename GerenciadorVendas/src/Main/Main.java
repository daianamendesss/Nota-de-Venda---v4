package Main;

import java.util.Scanner;
import model.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Produto notebook = new Produto("Notebook", 3000.00, 10);
        Produto mouse = new Produto("Mouse", 50.00, 20);

        // Criando estoque e adicionando produtos
        Estoque estoque = new Estoque();
        estoque.adicionarProduto(notebook, 10);
        estoque.adicionarProduto(mouse, 20);

        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Criando venda
        Venda venda = new Venda();

        // Pergunta ao usuário sobre os produtos
        System.out.println("Escolha os produtos que você deseja comprar:");

        // Produtos disponíveis
        Produto[] produtos = {notebook, mouse};
        for (int i = 0; i < produtos.length; i++) {
            System.out.println((i + 1) + ". " + produtos[i].getDescricao() + " - R$ " + produtos[i].getPreco());
        }

        // Pergunta a quantidade do produto escolhido
        for (Produto produto : produtos) {
            System.out.print("Quantos " + produto.getDescricao() + " você deseja comprar? ");
            int quantidade = scanner.nextInt();

            // Verifica a disponibilidade no estoque
            if (estoque.verificarDisponibilidade(produto, quantidade)) {
                ItemVenda item = new ItemVenda(produto, quantidade);
                venda.adicionarItem(item);
                // Dá baixa no estoque
                estoque.darBaixa(produto, quantidade);
                System.out.println(quantidade + " " + produto.getDescricao() + "(s) adicionado(s) à venda.");
            } else {
                System.out.println("Desculpe, não temos estoque suficiente de " + produto.getDescricao() + ".");
            }
        }

        // Pergunta sobre a forma de pagamento
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito (5% juros)");
        System.out.println("2. Cartão de Débito (sem juros)");
        System.out.println("3. Dinheiro/Pix (5% desconto)");
        System.out.print("Escolha (1-3): ");
        int formaPagamento = scanner.nextInt();

        // Calcula o valor total com base na forma de pagamento
        double valorFinal = venda.calcularTotal();
        String forma = "";
        if (formaPagamento == 1) {
            valorFinal *= 1.05; // 5% juros no cartão de crédito
            forma = "Cartão de Crédito";
        } else if (formaPagamento == 2) {
            forma = "Cartão de Débito";
        } else if (formaPagamento == 3) {
            valorFinal *= 0.95; // 5% desconto no dinheiro/Pix
            forma = "Dinheiro/Pix";
        }

        // Definir a data e o valor do pagamento
        String data = "23/11/2024"; // Exemplo de data fixa
        Pagamento pagamento = new Pagamento(data, valorFinal, forma);
        venda.definirPagamento(pagamento);

        // Exibir os detalhes da venda
        GerenciadorVenda gerenciador = new GerenciadorVenda(estoque);
        if (gerenciador.realizarVenda(venda)) {
            venda.exibirDetalhesDaVenda();
        }

        scanner.close(); // Fechar o scanner no final
    }
}
