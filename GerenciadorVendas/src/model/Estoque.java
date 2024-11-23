package model;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> produtos; // Estoque de produtos

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    // Método para adicionar produtos ao estoque
    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.put(produto, quantidade);
    }

    // Verifica a disponibilidade de um produto no estoque
    public boolean verificarDisponibilidade(Produto produto, int quantidade) {
        Integer quantidadeEstoque = produtos.get(produto);
        return quantidadeEstoque != null && quantidadeEstoque >= quantidade;
    }

    // Dá baixa no estoque após uma venda
    public void darBaixa(Produto produto, int quantidade) {
        Integer quantidadeEstoque = produtos.get(produto);
        if (quantidadeEstoque != null && quantidadeEstoque >= quantidade) {
            produtos.put(produto, quantidadeEstoque - quantidade);
        }
    }

    // Retorna os itens no estoque (mapeados por produto e quantidade)
    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }
}
