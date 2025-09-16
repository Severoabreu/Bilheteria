package Bilheteria;

import java.util.Scanner;

public class Cinema {
    private static final Bilheteria bilheteria = new Bilheteria();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int qtdIngressos;
            int idadeCliente;
            int tipoIngresso;

            System.out.println("Bem vindo(a) ao Cinema!");
            System.out.println("""
                    *** INGRESSOS ***
                    1 - INTEIRO - R$ 30,00
                    2 - PROMOCIONAL - R$ 21,00
                    3 - MEIA-ENTRADA - R$ 15,00
                    * MENORES DE 5 ANOS TÊM ENTRADA GRATUITA *
                    * MEIA-ENTRADA APENAS PARA MENORES DE 18 ANOS OU MAIORES DE 60 ANOS *
                    """);

            System.out.println("Quantos ingressos?: ");
            qtdIngressos = input.nextInt();

            System.out.println("Qual sua idade?: ");
            do {
                idadeCliente = input.nextInt();
                if (idadeCliente < 0 || idadeCliente > 120) {
                    System.out.println("Idade inválida!");
                }
            }
            while (idadeCliente < 0 || idadeCliente > 120);

            System.out.println("Qual o tipo dos ingressos?: ");
            tipoIngresso = input.nextInt();

            Venda venda = new Venda(qtdIngressos, idadeCliente, tipoIngresso);
            venda.calcularValorTotal();

            String[] ingressos = {"GRATUITO", "INTEIRO", "PROMOCIONAL", "MEIA-ENTRADA"};
            String ingressoAplicado = ingressos[venda.getTipoIngressoAplicado()];

            System.out.println("Ingresso aplicado: " + ingressoAplicado);
            System.out.println("Quantidade de ingressos: " + venda.getQuantidadeIngressos());
            System.out.println("Valor total: R$ " + venda.getValorTotal());

            if (ingressos[venda.getTipoIngressoAplicado()].equals("GRATUITO")) {
                System.out.println("Obrigado pela preferência! Aproveite o filme!");
            }
            else {
                int metodoPagamento;
                System.out.print("""
                        Qual o método de pagamento?:
                        1 - Dinheiro
                        2 - Cartão
                        """);
                System.out.print("-> ");
                do {
                    metodoPagamento = input.nextInt();
                    if (metodoPagamento == 1) {
                        System.out.println("Valor da compra: R$ " + venda.getValorTotal());
                        System.out.print("Coloque o valor em dinheiro: ");
                        double dinheiro = input.nextDouble();
                        System.out.println(venda.pagamento(dinheiro));
                    } else if (metodoPagamento == 2) {
                        System.out.println("Venda realizada com sucesso! Aproveite o filme!");
                    } else {
                        System.out.println("Método inválido.");
                    }
                } while (metodoPagamento != 1 && metodoPagamento != 2);
            }

            bilheteria.salvarInfoCliente(ingressoAplicado, qtdIngressos, venda.getValorTotal());

            System.out.println("Atender próximo cliente? (S/N)");
            char resposta = input.next().toUpperCase().charAt(0);
            if (resposta == 'N') {
                System.out.println(bilheteria.exibirRelatorio());
                break;
            }
        }
    }
}
