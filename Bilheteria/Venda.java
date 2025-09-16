package Bilheteria;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private final List<Ingresso> ingressos = new ArrayList<>();
    private double valorTotal = 0.0;

    public void adicionarIngresso(int idadeCliente, int tipoIngressoEscolhido) {
        Ingresso ingresso = new Ingresso(idadeCliente, tipoIngressoEscolhido);
        ingressos.add(ingresso);
        valorTotal += ingresso.getPreco();
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
        valorTotal += ingresso.getPreco();
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

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}
