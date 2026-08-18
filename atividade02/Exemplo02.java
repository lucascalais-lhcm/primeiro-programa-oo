public class Exemplo02 {

    static class SaldoInsuficienteException extends RuntimeException {
        public SaldoInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    static class ContaBancaria {
        protected double saldo;

        public void depositar(double valor) {
            saldo += valor;
        }

        public void sacar(double valor) {
            if (valor > saldo) {
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }
            saldo -= valor;
        }
    }

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(100.00);

        try {
            conta.sacar(500.00);
        } catch (SaldoInsuficienteException excecao) {
            System.out.println("Erro: " + excecao.getMessage());
        }

        System.out.println("Saldo final: " + conta.saldo);
    }
}