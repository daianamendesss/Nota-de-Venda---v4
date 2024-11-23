package model;

public class ItemEstoque {
    private EspecificacaoProduto produto;
    private int quantidade;

    public ItemEstoque(EspecificacaoProduto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public EspecificacaoProduto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
