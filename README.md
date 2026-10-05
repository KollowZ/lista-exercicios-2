# Lista de Exercícios 02 — Programação Orientada a Objetos

Soluções completas da Lista de Exercícios 02 em Java, com as questões teóricas respondidas e as questões práticas implementadas.

## Ambiente

- Java JDK 21 (Eclipse Temurin)
- IntelliJ IDEA Community
- Visual Studio Code
- Extensão IFPB Pack
- Java Extension Pack

## Questão 1 — Getters, setters e encapsulamento

**Getters** são métodos usados para consultar o valor de um atributo privado. **Setters** são métodos usados para alterar esse valor de forma controlada.

O **encapsulamento** consiste em esconder os detalhes internos de uma classe e permitir acesso aos seus dados por meio de uma interface controlada, normalmente com atributos `private` e métodos públicos.

Um setter pode preservar a integridade dos dados ao validar o novo valor antes de alterar o atributo. Por exemplo, se um produto não pode ter preço negativo, o setter deve rejeitar valores menores que zero.

Exemplo:

```java
private double preco;

public double getPreco() {
    return preco;
}

public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    }
}
```

Assim, a classe impede que seu estado fique inválido.

## Questão 2 — Sistema de biblioteca

As informações relevantes de um livro podem incluir **título, autor, ISBN, editora, ano de publicação, gênero e disponibilidade**.

A classe `Livro` representa uma abstração porque modela, no programa, somente as características e comportamentos relevantes de um livro no contexto do sistema. Os detalhes desnecessários para esse contexto ficam ocultos.

Exemplos de métodos que podem existir na classe `Livro`:

1. `emprestar()` — marca o livro como indisponível.
2. `devolver()` — torna o livro disponível novamente.
3. `exibirInfo()` — mostra os dados do livro.

## Questão 3 — Classe Produto

Implementação em `src/Produto.java` com:

- atributos `private` `codigo`, `nome`, `preco` e `estoque`;
- construtor com os quatro parâmetros;
- getters para todos os atributos;
- setter somente para `preco`;
- validação para impedir preço negativo;
- método `exibirInfo()`.

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

## Questão 4 — Classe ContaCorrente

Implementação em `src/ContaCorrente.java` e `src/Main.java`.

A conta possui `numero`, `titular` e `saldo`, todos privados. O construtor recebe o número e o titular e inicia o saldo em zero.

As operações de saque e depósito validam valores positivos e limitam cada operação a **R$ 10.000,00**. O saque também verifica se existe saldo suficiente.

O `Main` solicita os dados da conta e mantém um menu para sacar, depositar, consultar o saldo ou sair.

### Como executar

No IntelliJ IDEA, abra `D:\lista-exercicios-2`, marque o JDK 21 como SDK do projeto e execute `Main.java`.

No terminal, dentro da pasta do projeto:

```text
javac -d out src\*.java
java -cp out Main
```

## Estrutura

```text
lista-exercicios-2/
├── src/
│   ├── Produto.java
│   ├── ContaCorrente.java
│   └── Main.java
├── enunciado.md
├── respostas.md
├── Lista de exercícios 02.pdf
├── .gitignore
└── README.md
```

Todas as quatro questões da lista estão documentadas e as questões práticas estão implementadas em Java.