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
