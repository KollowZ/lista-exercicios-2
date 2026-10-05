# Respostas — Lista de Exercícios 02

## 1. Getters, setters e encapsulamento

Getter é o método que permite consultar, de maneira controlada, o valor de um atributo privado. Setter é o método que permite alterar esse valor, também de forma controlada.

Encapsulamento é o princípio de esconder os dados internos de um objeto e controlar como eles podem ser acessados ou modificados. Em Java, isso é normalmente feito declarando os atributos como `private` e disponibilizando métodos públicos quando necessário.

Um setter preserva a integridade dos dados quando valida o valor recebido antes de alterar o atributo. Por exemplo:

```java
private double preco;

public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    } else {
        System.out.println("Preço inválido: não pode ser negativo.");
    }
}
```

Nesse caso, a classe nunca aceita um preço negativo por meio desse setter.

## 2. Sistema de biblioteca

As informações relevantes de um livro dependem do objetivo do sistema, mas normalmente incluem título, autor, ISBN, editora, ano de publicação, gênero e situação de disponibilidade.

`Livro` é uma abstração porque representa, no sistema, apenas as características e comportamentos relevantes de um livro. O programa não precisa representar todos os detalhes existentes em um livro físico; ele trabalha com uma representação simplificada adequada ao problema.

Três métodos possíveis são:

```java
public void emprestar() { /* ... */ }
public void devolver() { /* ... */ }
public void exibirInfo() { /* ... */ }
```

`emprestar()` altera a disponibilidade, `devolver()` libera o livro novamente e `exibirInfo()` apresenta suas informações.

## 3. Produto

```java
public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int codigo, String nome, double preco, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido: não pode ser negativo.");
        }
    }

    public void exibirInfo() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + String.format("%.2f", preco));
        System.out.println("Estoque: " + estoque);
    }
}
```

A implementação atende ao encapsulamento pedido: todos os atributos são privados, existem getters para todos eles e somente o preço possui setter, com validação contra valores negativos.

## 4. ContaCorrente

### `ContaCorrente.java`

```java
public class ContaCorrente {
    private int numero;
    private String titular;
    private float saldo;

    public ContaCorrente(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0f;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public void sacar(float valor) {
        if (valor <= 0) {
            System.out.println("O valor do saque deve ser positivo.");
        } else if (valor > 10000) {
            System.out.println("O saque não pode ser superior a R$ 10.000,00 por operação.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        }
    }

    public void depositar(float valor) {
        if (valor <= 0) {
            System.out.println("O valor do depósito deve ser positivo.");
        } else if (valor > 10000) {
            System.out.println("O depósito não pode ser superior a R$ 10.000,00 por operação.");
        } else {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        }
    }

    public float consultarSaldo() {
        return saldo;
    }
}
```

### `Main.java`

```java
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
```

A solução respeita as regras da questão: atributos privados, saldo inicial em zero, saque e depósito com limite de R$ 10.000 por operação, bloqueio de valores não positivos, bloqueio de saque acima do saldo e menu interativo.
