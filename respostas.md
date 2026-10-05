# Lista de Exercícios 02 — Respostas e Códigos em Java

## Questão 1 — Getters e setters

### Resposta

É uma boa prática usar getters e setters em vez de deixar os atributos públicos porque isso aplica o **encapsulamento**. Os atributos ficam protegidos e a classe pode controlar como seus dados são consultados ou alterados.

Com atributos públicos, qualquer parte do programa poderia colocar um valor inválido diretamente no objeto. Com um setter, podemos validar o valor antes de modificar o atributo.

### Exemplo em Java

```java
public class Produto {
    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido: não pode ser negativo.");
        }
    }
}
```

Nesse exemplo, o preço não pode receber um valor negativo por meio do setter. Dessa forma, a classe consegue preservar a integridade do objeto.

---

## Questão 2 — Sistema de controle de biblioteca

### a) Informações relevantes de um livro

Para um sistema de biblioteca, podemos considerar relevantes as seguintes informações:

- título;
- autor;
- ISBN;
- editora;
- ano de publicação;
- gênero;
- quantidade de exemplares;
- disponibilidade.

Essas informações permitem identificar o livro e controlar sua utilização na biblioteca.

### b) Por que `Livro` é uma abstração?

A classe `Livro` é uma abstração porque representa no programa um objeto do mundo real por meio das características e comportamentos importantes para o sistema.

Um livro físico possui muitos detalhes, mas o sistema não precisa representar todos eles. A classe seleciona apenas o que é relevante para o problema, como título, autor, ISBN e disponibilidade.

### c) Pelo menos 3 métodos da classe `Livro`

Alguns métodos que fazem sentido são:

1. `emprestar()` — registra o empréstimo do livro e altera sua disponibilidade.
2. `devolver()` — registra a devolução e torna o livro disponível novamente.
3. `exibirInfo()` — apresenta as informações do livro.

Outros métodos possíveis seriam `estaDisponivel()` e `alterarQuantidade()`.

### Exemplo de classe em Java

```java
public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro indisponível.");
        }
    }

    public void devolver() {
        disponivel = true;
        System.out.println("Livro devolvido com sucesso.");
    }

    public void exibirInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }
}
```

---

## Questão 3 — Classe `Produto`

### Resposta

A classe abaixo atende a todos os requisitos do enunciado: quatro atributos privados, construtor com quatro parâmetros, getters para todos os atributos, setter somente para `preco` com validação contra valores negativos e método `exibirInfo()`.

### Código — `Produto.java`

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

### Explicação

Os atributos são `private`, portanto não podem ser modificados diretamente de fora da classe. Os getters permitem consultar os dados. O único setter é `setPreco()`, que rejeita valores menores que zero.

---

## Questão 4 — Classe `ContaCorrente`

### Resposta

A implementação abaixo segue o enunciado: possui os três atributos privados, inicia o saldo em zero, limita saques e depósitos a R$ 10.000,00 por operação, impede valores de depósito não positivos, impede saques não positivos e não permite sacar mais do que o saldo disponível.

### Código — `ContaCorrente.java`

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

### Código — `Main.java`

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

### Explicação

O programa solicita o número e o titular da conta. O saldo começa em zero. Depois, um menu é exibido repetidamente até o usuário escolher a opção 4.

- **Sacar:** verifica se o valor é positivo, se não ultrapassa R$ 10.000,00 e se existe saldo suficiente.
- **Depositar:** verifica se o valor é positivo e se não ultrapassa R$ 10.000,00.
- **Consultar saldo:** mostra o saldo atual.
- **Sair:** encerra o programa.

---

# Conclusão

Todas as quatro questões da lista foram respondidas. As questões teóricas possuem explicação e exemplos em Java, e as questões práticas possuem código completo e funcional.
