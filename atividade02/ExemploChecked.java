import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExemploChecked {
    public static void main(String[] args) {

        // FRASE:
        // Checked obriga tratar (try/catch) ou declarar (throws); unchecked compila mesmo sem tratamento.

        try {
            FileReader arquivo = new FileReader("dados.txt"); // checked
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }
}