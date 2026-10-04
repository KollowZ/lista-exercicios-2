# Lista de Exercícios 2 — Programação Orientada a Objetos

Soluções da **Lista de Exercícios 2**, com foco em encapsulamento, abstração, getters/setters e implementação de classes em Java.

## Exercício 1 — Getters e setters

Getters e setters ajudam a manter os atributos encapsulados e permitem controlar como os dados de um objeto podem ser lidos ou alterados. Em vez de expor um atributo diretamente, a classe pode validar a informação antes de armazená-la.

**Exemplo:** se um produto não pode ter preço negativo, o setter pode rejeitar esse valor:

`java
public void setPreco(double preco) {
    if (preco >= 0) {
        this.preco = preco;
    }
}
`

Assim, a própria classe protege a integridade do seu estado.

## Exercício 2 — Sistema de biblioteca

### a) Informações relevantes de um livro

Alguns atributos possíveis são:

- ISBN
- título
- autor
- editora
- ano de publicação
- gênero
- quantidade disponível

### b) Por que `Livro` é uma abstração?

A classe `Livro` representa, no código, as características e comportamentos relevantes de um livro real para o sistema. Ela abstrai detalhes desnecessários e concentra apenas o que é importante para o domínio da biblioteca.

### c) Métodos possíveis

- `emprestar()`
- `devolver()`
- `estaDisponivel()`

Outros métodos, como `exibirInfo()`, também poderiam fazer sentido.

## Exercício 3 — Produto

A solução está em `src/Produto.java`. A classe possui os quatro atributos privados solicitados, construtor, getters, setter somente para preço com validação e `exibirInfo()`.

## Exercício 4 — ContaCorrente

A solução está em:

- `src/ContaCorrente.java`
- `src/Main.java`

A conta inicia com saldo zero. O menu permite sacar, depositar, consultar o saldo e sair. As operações respeitam o limite de R$ 10.000,00 por operação e as regras de validação solicitadas.

## Como executar

É necessário ter o **JDK** instalado.

Na pasta `src`:

```text
javac *.java
java Main
```

## Arquivo original

O PDF original da lista está incluído no repositório como `Lista de exercícios 02.pdf`.
