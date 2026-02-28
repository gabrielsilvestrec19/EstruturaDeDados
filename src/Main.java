import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Leitura do Arquivo
        File arquivo = new File("texto.txt");

        try (Scanner sc = new Scanner(arquivo)) {
                System.out.println(sc.nextLine());    
        } catch (FileNotFoundException e) {
            System.out.println("Erro" + e.getMessage());
        }
        
    }
}