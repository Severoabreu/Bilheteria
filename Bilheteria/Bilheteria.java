package Bilheteria;

import java.util.HashMap;
import java.util.Map;

public class Bilheteria {
    private int totalIngressos;
    private final Map<String, Integer> qtdIngressosPorTipo = new HashMap<>();
    private double valorDia;

    public void salvarInfoCliente(String ingressoAplicado, int qtdIngressos, double valorArrecadado) {
        totalIngressos += qtdIngressos;

        if (qtdIngressosPorTipo.containsKey(ingressoAplicado)) {
            int qtdIngressosAtual = qtdIngressosPorTipo.get(ingressoAplicado);
            int novoQtdIngressos = qtdIngressos + qtdIngressosAtual;
            qtdIngressosPorTipo.put(ingressoAplicado, novoQtdIngressos);
        } else {
            qtdIngressosPorTipo.put(ingressoAplicado, qtdIngressos);
        }

        if (!ingressoAplicado.equals("GRATUITO")) {
            valorDia += valorArrecadado;
        }
    }

    public String exibirRelatorio() {
        return String.format("""
                * RELATÓRIO DIÁRIO *
                
                TOTAL DE INGRESSOS VENDIDOS: %d
                
                QUANTIDADE DE INGRESSOS (POR TIPO):
                    - INTEIRO      -> %d
                    - PROMOCIONAL  -> %d
                    - MEIA-ENTRADA -> %d
                    - GRATUITO     -> %d
                
                VALOR ARRECADADO: R$ %.2f
                """, totalIngressos,
                qtdIngressosPorTipo.getOrDefault("INTEIRO", 0),
                qtdIngressosPorTipo.getOrDefault("PROMOCIONAL", 0),
                qtdIngressosPorTipo.getOrDefault("MEIA-ENTRADA", 0),
                qtdIngressosPorTipo.getOrDefault("GRATUITO", 0),
                valorDia);
    }
}
