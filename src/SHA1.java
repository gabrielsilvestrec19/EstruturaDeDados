import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA1{
//Método pegue atráves do SHA1-online
public static String gerarSHA1(String input) {
        if (input == null || input.isEmpty()) return "Documento vazio";
        try {
            MessageDigest mDigest = MessageDigest.getInstance("SHA-1");
            byte[] result = mDigest.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro: Algoritmo SHA-1 não encontrado.");
            return "";
        }
    } 
}
