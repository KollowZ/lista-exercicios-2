# Lista de Exercícios 2 — Enunciado

## 1. Getters e setters

Explique por que é considerado boa prática usar getters e setters em vez de tornar os atributos públicos em uma classe. Dê um exemplo onde usar um setter permite controlar melhor a integridade dos dados de um objeto.

## 2. Sistema de controle de biblioteca

Considere que você está modelando um sistema de controle de biblioteca.

### a)
Quais informações você considera relevantes para representar um livro em um sistema?

### b)
Por que podemos dizer que uma classe `Livro` seria uma abstração no seu código?

### c)
Liste ao menos 3 métodos que fariam sentido existir nessa classe.

## 3. Classe Produto

Implemente uma classe `Produto` com os seguintes atributos privados:

- `codigo` (int)
- `nome` (String)
- `preco` (double)
- `estoque` (int)

Inclua:

- Um construtor que receba os quatro parâmetros.
- Getters para todos os atributos.
- Um setter apenas para o preço, que não deve aceitar valores negativos.
- Um método `exibirInfo()` que imprime todas as informações do produto.

## 4. Classe ContaCorrente

Crie uma classe chamada `ContaCorrente` com os seguintes atributos privados:

- `numero` (int)
- `titular` (String)
- `saldo` (float)

Implemente os seguintes métodos públicos:

- `sacar(float valor)`: subtrai o valor do saldo, se houver saldo suficiente. Não permitindo sacar mais de 10000 por operação.
- `depositar(float valor)`: adiciona o valor ao saldo, apenas se o valor for positivo e se não for superior a 10000.
- `consultarSaldo()`: retorna o saldo atual.

Crie também uma classe principal (por exemplo, `Main`) que:

- Leia do teclado os dados iniciais de uma conta (número, titular).
- O saldo inicial deve ser 0.

Exiba um menu em loop, permitindo que o usuário escolha entre:

- Sacar um valor.
- Depositar um valor.
- Consultar o saldo.
- Sair do programa.

O menu deve continuar sendo exibido até que o usuário escolha sair. Pode-se reutilizar o código feito em sala.
