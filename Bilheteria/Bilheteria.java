package Bilheteria;

import java.util.Scanner;

public class Bilheteria {
      int totalIngressosVendidos;
    double totalValorArrecadado;
    int totalInteiras;
    int totalMeias;
    int totalPromocionais;
    int totalGratuitos;
    private Scanner scanner;

    public Bilheteria() {
        this.totalIngressosVendidos = 0;
        this.totalValorArrecadado = 0.0;
        this.totalInteiras = 0;
        this.totalMeias = 0;
        this.totalPromocionais = 0;
        this.totalGratuitos = 0;
        this.scanner = new Scanner(System.in);
    }
    
}
