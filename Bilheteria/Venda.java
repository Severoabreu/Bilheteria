package Bilheteria;

public class Venda {
    int quantidadeIngressos;
    int IdadeCliente;
    String tipoIngressoAplicado; 
    int tipoIngressoEscolhido;
    double valorTotal; 
    final double Preco_base = 30.0;

    Venda(int quantidadeIngressos, int IdadeCliente, int tipoIngressoEscolhido) {
        this.quantidadeIngressos = quantidadeIngressos;
        this.IdadeCliente = IdadeCliente;
        this.tipoIngressoEscolhido = tipoIngressoEscolhido;
    
    }
    public void calcularValorTotal() {
        if(IdadeCliente < 5){
            tipoIngressoAplicado = "Gratuito";
            valorTotal = 0.0;   
         } else {
            switch (tipoIngressoAplicado) {
                case "Meia-Entrada":
                    valorTotal = Preco_base * 0.5 * quantidadeIngressos;
                    break;
                case "Inteira":
                    valorTotal = Preco_base * quantidadeIngressos;
                    break;
                case "Promocional":
                    valorTotal = Preco_base * 0.7 * quantidadeIngressos;
                    break;  
                default:
                    break;
            }

         }

        }
    
    
    public double getValorTotal() {
        return valorTotal;
    }
    public String getTipoIngressoAplicado() {
        return tipoIngressoAplicado;
    }
    public int getQuantidadeIngressos() {
        return quantidadeIngressos;
    }
    public void exibirInformacoes() {
        System.out.println("Quantidade de Ingressos: " + quantidadeIngressos);
        System.out.println("Tipo de Ingresso Aplicado: " + tipoIngressoAplicado);
        System.out.println("Valor Total: R$ " + valorTotal);
    }
    
}
