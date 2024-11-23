package model;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    public Venda() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itens) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void definirPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void exibirDetalhesDaVenda() {
        System.out.println("\n=== Detalhes da Venda ===");
        for (ItemVenda item : itens) {
            System.out.printf("Produto: %s\nQuantidade: %d\nPreço unitário: R$%.2f\nPreço total do item: R$%.2f\n----------------------------\n",
                    item.getProduto().getDescricao(),
                    item.getQuantidade(),
                    item.getProduto().getPreco(),
                    item.calcularTotal());
        }
        System.out.printf("Valor total da venda: R$%.2f\n", calcularTotal());
        System.out.printf("Forma de pagamento: %s\n", pagamento.getForma());
        System.out.printf("Data: %s | Valor: R$%.2f\n", pagamento.getData(), pagamento.getValor());
        System.out.println("===========================");
    }
}
