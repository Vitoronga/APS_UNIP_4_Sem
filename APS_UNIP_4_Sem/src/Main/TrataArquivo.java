package Main;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrataArquivo {
    
    public static String LerTexto(String endereco) {
        String conteudo = "";
        
        try {
            File arquivo = new File(endereco);
            Scanner scanner = new Scanner(arquivo);
        
            while (scanner.hasNextLine()) {
                conteudo += scanner.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("ERRO DE LEITURA: " + e.getMessage());
        }
        
        
        return conteudo;
    }
    
    public static int[] LerValores(String endereco) {
        int[] valores;
        List<Integer> conteudo = new ArrayList<Integer>();
        
        // Obter conteúdo do arquivo
        try {
            File arquivo = new File(endereco);
            Scanner scanner = new Scanner(arquivo);
            
            
            int i = 0;
            while (scanner.hasNextInt()) {
                conteudo.add(scanner.nextInt());
            }
        } catch (Exception e) {
            System.out.println("ERRO DE LEITURA: " + e.getMessage());
        }
        
        // transformar de lista para array
        valores = new int[conteudo.size()];
        
        for (int i = 0; i < conteudo.size(); i++) {
            valores[i] = conteudo.get(i);
        }
        
        return valores;
    }
    
    public static void EscreverValores(String endereco, int[] valores) {
        // Obter conteúdo do arquivo
        String conteudo = "";

        try {
            FileWriter escritor = new FileWriter(endereco);
            
            for (int valor : valores) {
                escritor.write(String.format("%d\n", valor));
            }
            
            escritor.close();
        } catch (Exception e) {
            System.out.println("ERRO DE LEITURA: " + e.getMessage());
        }
    }
    
    public static void CriarArquivo(String endereco) {
        File f = new File(endereco);
        
        try {
            f.createNewFile();
        } catch (Exception e) {
            System.out.println("ERRO DE CRIAÇÃO DO ARQUIVO: " + e.getMessage());
        }
    }
}
