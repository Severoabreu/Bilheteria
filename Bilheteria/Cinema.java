package Bilheteria;

import java.util.Scanner;

public class Cinema {
    private static final Bilheteria bilheteria = new Bilheteria();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bem vindo(a) ao Cinema!");
            System.out.println("""
                    *** INGRESSOS ***
                    1 - INTEIRO - R$ 30,00
                    2 - PROMOCIONAL - R$ 21,00
                    3 - MEIA-ENTRADA - R$ 15,00
                    * MENORES DE 5 ANOS TÊM ENTRADA GRATUITA *
                    * MEIA-ENTRADA APENAS PARA MENORES DE 18 ANOS OU MAIORES DE 60 ANOS *
                    """);

            System.out.print("Quantos ingressos deseja comprar?: ");
            int qtdIngressos = input.nextInt();

            Venda venda = new Venda(); // agora a venda vai ter vários ingressos

            for (int i = 1; i <= qtdIngressos; i++) {
                System.out.printf("Ingresso %d - Qual a idade do cliente?: ", i);
                int idadeCliente;
                do {
                    idadeCliente = input.nextInt();
                    if (idadeCliente < 0 || idadeCliente > 120) {
                        System.out.println("Idade inválida! Digite novamente:");
                    }
                } while (idadeCliente < 0 || idadeCliente > 120);

                System.out.println("""
                        Qual o tipo do ingresso? 
                        1 - INTEIRO 
                        2 - PROMOCIONAL 
                        3 - MEIA-ENTRADA
                        """);
                int tipoIngresso = input.nextInt();

                // cria ingresso e adiciona na venda
                Ingresso ingresso = new Ingresso(idadeCliente, tipoIngresso);
                ingresso.calcularPreco();
                venda.adicionarIngresso(ingresso);
            }

            System.out.println("Resumo da compra:");
            for (Ingresso ingresso : venda.getIngressos()) {
                String[] ingressosLabel = {"GRATUITO", "INTEIRO", "PROMOCIONAL", "MEIA-ENTRADA"};
                System.out.printf(" - %s (Idade: %d) -> R$ %.2f%n",
                        ingressosLabel[ingresso.getTipoAplicado()],
                        ingresso.getIdadeCliente(),
                        ingresso.getPreco());
            }
            System.out.println("Valor total: R$ " + venda.getValorTotal());

            // Pagamento
            if (venda.getValorTotal() > 0) {
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
            } else {
                System.out.println("Ingressos gratuitos! Aproveite o filme!");
            }

            // Atualiza bilheteria ingresso por ingresso
            for (Ingresso ingresso : venda.getIngressos()) {
                String[] ingressosLabel = {"GRATUITO", "INTEIRO", "PROMOCIONAL", "MEIA-ENTRADA"};
                bilheteria.salvarInfoCliente(
                        ingressosLabel[ingresso.getTipoAplicado()],
                        1,
                        ingresso.getPreco()
                );
            }

            System.out.println("Atender próximo cliente? (S/N)");
            char resposta = input.next().toUpperCase().charAt(0);
            if (resposta == 'N') {
                System.out.println(bilheteria.exibirRelatorio());
                break;
            }
        }
    }
}
