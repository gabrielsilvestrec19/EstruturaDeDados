import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
        //Leitura do Arquivo
        File arquivo = new File("texto.txt");
        Scanner sc = new Scanner(arquivo);
        while (sc.hasNext()){
            System.out.println(sc.next());    
        }
        sc.close();
    }
}
