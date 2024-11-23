package model;

public class ItemVenda {
    private Produto produto; // Produto que foi vendido
    private int quantidade;  // Quantidade vendida

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularTotal() {
        return produto.getPreco() * quantidade;  // Calcula o total do item
    }
}
