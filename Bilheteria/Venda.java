package Bilheteria;

public class Venda {
    private final int quantidadeIngressos;
    private final int idadeCliente;
    private int tipoIngressoAplicado;
    private final int tipoIngressoEscolhido;
    private double valorTotal;

    public Venda(int quantidadeIngressos, int idadeCliente, int tipoIngressoEscolhido) {
        this.quantidadeIngressos = quantidadeIngressos;
        this.idadeCliente = idadeCliente;
        this.tipoIngressoEscolhido = tipoIngressoEscolhido;
    }

    public void calcularValorTotal() {
        double preco_base = 30.0;

        for (int i = 0; i < quantidadeIngressos; i++) {
            if (idadeCliente < 5) {
                tipoIngressoAplicado = 0;
                valorTotal = 0.0;
            } else if (idadeCliente < 18 || idadeCliente >= 60 && tipoIngressoEscolhido != 3) {
                tipoIngressoAplicado = 3;
                valorTotal = preco_base * 0.5 * quantidadeIngressos;
                System.out.println("Você tem direito à ingressos de meia-entrada!");
            } else {
                switch (tipoIngressoEscolhido) {
                    case 1:
                        tipoIngressoAplicado = 1;
                        valorTotal = preco_base * quantidadeIngressos;
                        break;
                    case 2:
                        tipoIngressoAplicado = 2;
                        valorTotal = preco_base * 0.7 * quantidadeIngressos;
                        break;
                    case 3:
                        tipoIngressoAplicado = 3;
                        valorTotal = preco_base * 0.5 * quantidadeIngressos;
                        break;
                    default:
                        System.out.println("Insira um tipo de ingresso válido (1, 2 ou 3)");
                }
            }
        }
    }

    public String pagamento(double valorDinheiro) {
        if (valorDinheiro < valorTotal) return "Valor insuficiente.";

        if (valorDinheiro > valorTotal) {
            double troco = valorDinheiro - valorTotal;
            return "Venda realizada com sucesso! Aproveite o filme!\nTroco: R$ " + troco;
        }

        return "Venda realizada com sucesso! Aproveite o filme!";
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public int getTipoIngressoAplicado() {
        return tipoIngressoAplicado;
    }
    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }
}
