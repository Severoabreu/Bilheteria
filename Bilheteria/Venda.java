package Bilheteria;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private final List<Ingresso> ingressos = new ArrayList<>();

    public void adicionarIngresso(Ingresso ingresso) {
        ingresso.calcularPreco();
        ingressos.add(ingresso);
    }

    public double getValorTotal() {
        return ingressos.stream().mapToDouble(Ingresso::getPreco).sum();
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}
