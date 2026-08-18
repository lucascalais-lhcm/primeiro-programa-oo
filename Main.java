// ATIVIDADE PRÁTICA 01 — Modelos e Linguagem de Programação III
// Este arquivo contém:
// (A) Interface + polimorfismo (MeioDePagamento)
// (B) Herança + sobrescrita (ContaBancaria)
// Comentários indicam onde aparecem os conceitos pedidos.

/////////////////////////////
// (A) INTERFACE + IMPLEMENTS
/////////////////////////////

// INTERFACE: contrato
interface MeioDePagamento {
    void pagar(double valor);
}

// CLASSE + IMPLEMENTA INTERFACE
class Pix implements MeioDePagamento {
    @Override // SOBRESCRITA (implementação do método da interface)
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via Pix.");
    }
}

// CLASSE + IMPLEMENTA INTERFACE
class Cartao implements MeioDePagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com cartão.");
    }
}

// CLASSE NOVA (Parte 4) + IMPLEMENTA INTERFACE
class Boleto implements MeioDePagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Boleto de R$ " + valor + " gerado.");
    }
}

/////////////////////
// (B) HERANÇA (BANCO)
/////////////////////

// CLASSE
class ContaBancaria {
    // ATRIBUTO
    // ENCAPSULAMENTO: protected
    protected double saldo;

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado. Saldo: R$ " + saldo);
    }
}

// HERANÇA: extends
class ContaPoupanca extends ContaBancaria {
}

// HERANÇA: extends
class ContaCorrente extends ContaBancaria {
    // SOBRESCRITA: @Override
    @Override
    public void depositar(double valor) {
        // super: evita recursão infinita e chama o método do pai
        super.depositar(valor - 1.00);
        System.out.println("Foi descontada uma taxa de R$ 1,00.");
    }
}

public class Main {
    public static void main(String[] args) {

        // POLIMORFISMO: mesma variável (MeioDePagamento) aponta para objetos diferentes
        MeioDePagamento pagamento = new Pix(); // CRIAÇÃO DE OBJETO: new
        pagamento.pagar(100.00);

        pagamento = new Cartao();              // CRIAÇÃO DE OBJETO: new
        pagamento.pagar(250.00);

        pagamento = new Boleto();              // CRIAÇÃO DE OBJETO: new
        pagamento.pagar(80.00);

        // HERANÇA em ação
        ContaPoupanca poupanca = new ContaPoupanca(); // CRIAÇÃO DE OBJETO
        poupanca.depositar(100.00);

        // SOBRESCRITA em ação
        ContaCorrente corrente = new ContaCorrente(); // CRIAÇÃO DE OBJETO
        corrente.depositar(100.00);
    }
}