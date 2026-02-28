import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File arquivo = new File("C:/texto.txt");

        try (Scanner sc = new Scanner(arquivo)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro" + e.getMessage());
        }

    }
}