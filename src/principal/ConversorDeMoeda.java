package principal;

import servico.ServicoMoeda;
import java.util.Scanner;

public class ConversorDeMoeda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        boolean primeiraExecucao = true;

        while (continuar) {
            if (!primeiraExecucao) {
                System.out.println("\nGostaria de fazer outra conversão?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");

                System.out.print("Digite a opção desejada: ");
                int resposta = scanner.nextInt();

                if (resposta == 2) {
                    continuar = false;
                    System.out.println("Obrigado por usar o Conversor de Moedas! Até mais.");
                    break;
                }
            }

            System.out.println("\nEscolha uma opção de conversão:");
            System.out.println("1. Dólar → Real");
            System.out.println("2. Real → Dólar");
            System.out.println("3. Dólar → Peso Argentino");
            System.out.println("4. Peso Argentino → Dólar");
            System.out.println("5. Dólar → Peso Colombiano");
            System.out.println("6. Peso Colombiano → Dólar");

            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            String deMoeda = "";
            String paraMoeda = "";

            switch (opcao) {
                case 1: deMoeda = "USD"; paraMoeda = "BRL"; break;
                case 2: deMoeda = "BRL"; paraMoeda = "USD"; break;
                case 3: deMoeda = "USD"; paraMoeda = "ARS"; break;
                case 4: deMoeda = "ARS"; paraMoeda = "USD"; break;
                case 5: deMoeda = "USD"; paraMoeda = "COP"; break;
                case 6: deMoeda = "COP"; paraMoeda = "USD"; break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            double taxaDeCambio = ServicoMoeda.obterTaxaDeCambio(deMoeda, paraMoeda);
            double valorConvertido = valor * taxaDeCambio;

            System.out.printf("%.2f %s equivale a %.2f %s%n", valor, deMoeda, valorConvertido, paraMoeda);

            primeiraExecucao = false;
        }

        scanner.close();
    }
}

