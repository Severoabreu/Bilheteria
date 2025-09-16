package Bilheteria;

public class Ingresso {
    private final int idadeCliente;
    private final int tipoEscolhido;
    private int tipoAplicado;
    private double preco;

    public Ingresso(int idadeCliente, int tipoEscolhido) {
        this.idadeCliente = idadeCliente;
        this.tipoEscolhido = tipoEscolhido;
    }

    public void calcularPreco() {
        double precoBase = 30.0;

        if (idadeCliente < 5) {
            tipoAplicado = 0;
            preco = 0.0;
        } else if ((idadeCliente < 18 || idadeCliente >= 60) && tipoEscolhido != 3) {
            tipoAplicado = 3; // meia-entrada forçada
            preco = precoBase * 0.5;
        } else {
            switch (tipoEscolhido) {
                case 1 -> {
                    tipoAplicado = 1;
                    preco = precoBase;
                }
                case 2 -> {
                    tipoAplicado = 2;
                    preco = precoBase * 0.7;
                }
                case 3 -> {
                    tipoAplicado = 3;
                    preco = precoBase * 0.5;
                }
                default -> System.out.println("Tipo de ingresso inválido!");
            }
        }
    }

    public int getTipoAplicado() { return tipoAplicado; }
    public double getPreco() { return preco; }
    public int getIdadeCliente() { return idadeCliente; }
}
