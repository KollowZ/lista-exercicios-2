import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titular da conta: ");
        String titular = scanner.nextLine();

        ContaCorrente conta = new ContaCorrente(numero, titular);

        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor do saque: R$ ");
                    float saque = scanner.nextFloat();
                    conta.sacar(saque);
                    break;

                case 2:
                    System.out.print("Valor do depósito: R$ ");
                    float deposito = scanner.nextFloat();
                    conta.depositar(deposito);
                    break;

                case 3:
                    System.out.printf("Saldo atual: R$ %.2f%n", conta.consultarSaldo());
                    break;

                case 4:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
