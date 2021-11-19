package Main;

public class Ordenacao {
    public static void PrintarValores(int[] valores) {
        for (int valor : valores) {
            System.out.print(valor + " ");
        }                
        System.out.println("");
    }
    
    
    public static void BubbleSort(int[] valores) {
        int aux;
        
        for (int i = 0; i < valores.length; i++) {
            for (int j = i + 1; j < valores.length; j++) {
                if (valores[i] > valores[j]) {
                    aux = valores[i];
                    valores[i] = valores[j];
                    valores[j] = aux;
                }
            }
        }
    }
    
    public static void OrdenarInverso(int[] valores) {
        int maior;
        int aux;
        
        for (int i = 0; i < valores.length; i++) {
            maior = i;
            
            for (int j = i; j < valores.length; j++) {
                if (valores[j] > valores[maior]) maior = j;
            }
            
            aux = valores[i];
            valores[i] = valores[maior];
            valores[maior] = aux;
        }
    }
    
    /*
    public static void InsertionSort(int[] valores) {
        int aux;
        
        for (int i = 0; i < valores.length; i++) {
            for (int j = i; j == 0; j--) {
                if (valores[i] < valores[j]) {
                    aux = valores[i];
                    valores[i] = valores[j];
                    valores[j] = aux;
                } else break;
            }
        }
    }
    */
    
    public static void SelectionSort(int[] valores) {
        int menor;
        int aux;
        
        for (int i = 0; i < valores.length; i++) {
            menor = i;
            
            for (int j = i; j < valores.length; j++) {
                if (valores[j] < valores[menor]) menor = j;
            }
            
            aux = valores[i];
            valores[i] = valores[menor];
            valores[menor] = aux;
        }
    }
    
    // função auxiliar do QuickSort, responsável por dividir o vetor
    private static int Particionar (int valores[], int numEsq, int numDir)  
    {  
        int aux;
        int pivo = valores[numDir];  
        int i = (numEsq - 1);  

        for (int j = numEsq; j <= numDir - 1; j++)  
        {  
            // se o pivô for maior troca os valores  
            if (pivo >= valores[j])  
            {  
                i++;  
                aux = valores[i];  
                valores[i] = valores[j];  
                valores[j] = aux;  
            }  
        }
        
        aux = valores[i+1];  
        valores[i+1] = valores[numDir];  
        valores[numDir] = aux;  
        return (i + 1);  
    }  
  
    // função principal do QuickSort
    public static void QuickSort(int valores[], int numEsq, int numDir)  
    {  
        if (numEsq < numDir)  
        {  
            // p recebe posição da partição
            int p = Particionar(valores, numEsq, numDir); 
            QuickSort(valores, numEsq, p - 1);  
            QuickSort(valores, p + 1, numDir);  
        }
    }
}
