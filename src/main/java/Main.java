import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Main {

    private static HashMap<String, String> dados = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // aqui eu criei o arquivo dados.txt
        File file = new File("dados.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        //aqui eu peguei 50 nomes e cpfs que são gerados pelos nosso publics lá em baixo.
        for (int i = 1; i < 51; i++) {
            String nome = gerarNomes();
            String cpf = gerarCPFS();
            bw.write(nome + ";" + cpf);
            bw.newLine();

        }
        System.out.println("Dados gerados e salvos.");
        bw.close();


    }
    public static String gerarNomes() {
        Random rand = new Random();
        char[] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        return sb.toString();
    }
    public static String gerarCPFS() {
        Random rand = new Random();
        char[] letras = "123456789".toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 11; i++) {
            int ch = rand.nextInt(letras.length);
            sb.append(letras[ch]);
        }
        String cpf = sb.toString();
        return cpf.replaceAll("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})","$1\\.$2\\.$3-$4");
    }

}
