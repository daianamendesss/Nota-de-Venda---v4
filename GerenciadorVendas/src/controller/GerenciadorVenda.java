package controller;

import model.*;

public class GerenciadorVenda {
    private Estoque estoque;

    public GerenciadorVenda(Estoque estoque) {
        this.estoque = estoque;
    }

    public boolean realizarVenda(Venda venda) {
        for (ItemVenda item : venda.getItens()) {
            if (!estoque.verificarDisponibilidade(item.getProduto(), item.getQuantidade())) {
                System.out.printf("Produto %s não possui estoque suficiente.\n", item.getProduto().getDescricao());
                return false;
            }
        }

        // Dar baixa no estoque
        for (ItemVenda item : venda.getItens()) {
            estoque.darBaixa(item.getProduto(), item.getQuantidade());
        }

        return true; // Venda realizada com sucesso
    }
}
