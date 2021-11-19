package Main;

import java.util.Random;

public class Principal {
    private static Boolean checarOrdenacao(int[] valores) {
        for (int i = 0; i < valores.length - 1; i++) {
            if (valores[i] > valores[i + 1]) return false;
        }
        
        return true;
    }

    private static Boolean checarOrdenacaoInversa(int[] valores) {
        for (int i = 0; i < valores.length - 1; i++) {
            if (valores[i] < valores[i + 1]) return false;
        }
        
        return true;
    }
    
    private static int[] gerarNumeros(int qtde) { // inteiros
        int[] numeros = new int[qtde];
        
        Random rnd = new Random();
        
        for (int i = 0; i < qtde; i++) {
            numeros[i] = rnd.nextInt(Integer.MAX_VALUE);
        }

        return numeros;        
    }
    
    private static int[] gerarNumerosUnicos(int qtde) { // positivos
        int[] numeros = new int[qtde];
        int n;
        Random rnd = new Random();
        
        Boolean repeticao = false;
        for (int i = 0; i < numeros.length; i++) {
            
            do {
                n = rnd.nextInt(Integer.MAX_VALUE);
                
                for (int num : numeros) {
                    if (n == num) {
                        repeticao = true;
                        break;
                    }
                }
                
            } while (repeticao);
            repeticao = false;
            
            numeros[i] = n;
        }
        
        return numeros;
    }
        
    public static void main(String[] args) {
        String enderecoPasta = "src\\Main";
        //String enderecoArquivo = enderecoPasta + "\\data_100k_simples.txt";
        String enderecoArquivo = enderecoPasta + "\\dtaleat100kuni0.txt";
        
        int[] valores;        
        
        //valores = gerarNumerosUnicos(10000);
        valores = gerarNumeros(10000);
        //valores = TrataArquivo.LerValores(enderecoArquivo);
        
        
        
        // Criar arquivo com x itens ordenados inversamente
        /*
        String enderecoArquivoNovo = enderecoPasta + "\\data_10k_decre_unico.txt";        
        TrataArquivo.CriarArquivo(enderecoArquivoNovo);
        
        System.out.print("Valores iniciais: ");
        Ordenacao.PrintarValores(valores);
        Ordenacao.OrdenarInverso(valores);
        Ordenacao.PrintarValores(valores);        
        if (!checarOrdenacaoInversa(valores)) System.out.println("Não ordenou direito...");
        
        TrataArquivo.EscreverValores(enderecoArquivoNovo, valores);
        */
        
        // Parte principal de análise de desempenho
        
        int qtdeTestes = 5;
        int qtdeItens = valores.length;
        
        int[] tempValores;
        
        for (int i = 0; i < 3; i++) { // 3 tipos de ordenação
            double tempo = 0;
            double somaTempo = 0;
        
            for (int j = 0; j < qtdeTestes; j++) { // repetir várias vezes o teste
                tempValores = valores.clone();
                tempo = System.nanoTime();
                
                // ordenar, calcular tempo decorrido e verificar eficácia do escolhido
                switch (i) { 
                    case 0:
                        Ordenacao.BubbleSort(tempValores);
                        break;
                    case 1:
                        Ordenacao.SelectionSort(tempValores);
                        break;
                    case 2:
                        Ordenacao.QuickSort(tempValores, 0, tempValores.length - 1);
                        break;
                    default:
                        System.out.println("Sort não reconhecido...");
                        break;
                }
                
                tempo = System.nanoTime() - tempo;
                if (!checarOrdenacao(tempValores)) System.out.println("Não ordenou direito...");
                
                somaTempo += tempo;
            }

            somaTempo /= qtdeTestes;

            System.out.println("\nTempo médio gasto pelo sort " + i + " em " + 
                               qtdeTestes + " tentativas com " + qtdeItens + 
                               " itens: " + (somaTempo / 1000000) + "ms (milissegundos)");
        }
        
        // Escrita com saída do resultado
        /*
        valores = gerarNumerosUnicos(100);
        TrataArquivo.EscreverValores(enderecoArquivo, valores);
        
        System.out.println(TrataArquivo.LerTexto(enderecoArquivo));
        */
        
        // Criação de arquivos coms dados aleatórios
        /*
        String enderecoArquivoNovo = enderecoPasta + "\\data_500_simples.txt";        
        TrataArquivo.CriarArquivo(enderecoArquivoNovo);
        valores = gerarNumeros(500);
        TrataArquivo.EscreverValores(enderecoArquivoNovo, valores);
        */
    }
}
