package model;

public class Pagamento {
    private String data;
    private double valor;
    private String forma;

    public Pagamento(String data, double valor, String forma) {
        this.data = data;
        this.valor = valor;
        this.forma = forma;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getForma() {
        return forma;
    }
}
