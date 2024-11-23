package model;

public class EspecificacaoProduto {
    private String descricao;
    private double preco;

    public EspecificacaoProduto(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}
