/*
-Nome | Matrícula
-Mateus Silvestre Estevam | 2514879
-
-
-
-
-
*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
public static void main(String[] args) {
        String path = "texto.txt";
        Stack<ArvoreAVL> pilhaDeArvores = new Stack<>();
        try {
            List<String> todasAsLinhas = Files.readAllLines(Paths.get(path));

            for (String linha : todasAsLinhas) {
                if (linha.trim().isEmpty()) continue;
                List<String> listaPalavras = Arrays.stream(linha.split("\\s+"))
                        .map(p -> p.replaceAll("[^a-zA-ZçÇáéíóúÁÉÍÓÚ]", ""))
                        .collect(Collectors.toList());

                Collections.reverse(listaPalavras);
                ArvoreAVL avl = new ArvoreAVL();
                listaPalavras.forEach(avl::inserir);
                pilhaDeArvores.push(avl);
            }

            System.out.println("--- RESULTADO DA AUTENTICAÇÃO DIGITAL) ---\n");
            while (!pilhaDeArvores.isEmpty()) {
                ArvoreAVL arvore = pilhaDeArvores.pop();
                System.out.println(arvore.calcularHashes(arvore.raiz));
            }

        } catch (IOException e) {
            System.err.println("Erro ao localizar ou processar o arquivo: " + e.getMessage());
        }
    }
}
