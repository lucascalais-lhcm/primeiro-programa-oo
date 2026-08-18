public class Exemplo03 {

    static class ConexaoSimulada implements AutoCloseable {
        public ConexaoSimulada() {
            System.out.println("Conexão aberta.");
        }

        public void executar() {
            System.out.println("Executando operação...");
        }

        @Override
        public void close() {
            System.out.println("Conexão fechada.");
        }
    }

    public static void main(String[] args) {
        try (ConexaoSimulada conexao = new ConexaoSimulada()) { // try-with-resources
            conexao.executar();
        }
    }
}