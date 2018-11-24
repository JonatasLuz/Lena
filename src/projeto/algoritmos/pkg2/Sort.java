package projeto.algoritmos.pkg2;
public class Sort
{
    public int bubbleSort(int vetor[], int tamVetor)
    {
        int mediana;
        for(int j=1; j<tamVetor;j++)
        {
            for(int i=0; i<tamVetor-1;i++)
            {
                int key = vetor[j];
                if(vetor[i]>key)
                {
                    vetor[j]= vetor[i];
                    vetor[i]=key;
                }
            }
        }
        mediana = vetor[tamVetor/2];
        return mediana;
    }
    
    public int insertionSort(int vetor[], int tamVetor)
    {
        int mediana;
        for(int j=1; j<tamVetor;j++)
        {
            int key = vetor[j];
            int i;
            for(i = j-1; i >=0&& vetor[i]>key;i--)
            {
                    vetor[i+1]= vetor[i];
            }
            vetor[i+1]=key;
        }
        mediana = vetor[(tamVetor/2)];
        return mediana;
    }
    
    public int selectionSort(int vetor[], int tamVetor)
    {
        int mediana;
        int min, indice;
        for(int i =0; i<tamVetor; i++)
        {
            min = vetor[i];
            indice = i;
            for(int j=i+1;j<tamVetor; j++)
            {
                if(min > vetor[j])
                {
                    min = vetor[j];
                    indice = j;
                }
            }
            vetor[indice] = vetor[i];
            vetor[i] = min;   
        }
        mediana = vetor[tamVetor/2];
        return mediana;
    }
           
    public int quickSort(int vetor[],int p, int r) 
    {
        int mediana;
        int meio;
        if (p < r) 
        {
            meio = particionar(vetor, p, r);
            quickSort(vetor, p, meio);
            quickSort(vetor, meio + 1, r);
        }
         mediana = vetor[r/2];
         return mediana;
    }
 
    public int particionar(int vetor[], int p, int r) 
    {
        int pivo, topo, i;
        pivo = vetor[p];
        topo = p;
            for (i = p + 1; i < r; i++) 
            {
                    if(vetor[i] < pivo) 
                    {
                        vetor[topo] = vetor[i];
                        vetor[i] = vetor[topo + 1];
                        topo++; 
                    }
            }
            vetor[topo] = pivo;
          return topo;
    }
}

