package projeto.algoritmos.pkg2;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ProjetoAlgoritmos2 
{
    public static void main(String[] args) 
    {
        long init;  
        long end;  
        long diff;
        init = System.currentTimeMillis();
        Arquivo arquivo = new Arquivo();
        int ncolunas, nlinhas;
        arquivo.copiaArquivo();
        nlinhas = arquivo.getLinha();
        ncolunas = arquivo.getColuna();
        int matriz[][] = new int[nlinhas][ncolunas];
        int matrizArranjada[][]= new int[nlinhas][ncolunas];
        for(int a =0; a<nlinhas; a++)
        {
            for(int b =0; b<ncolunas; b++)
            {
                matriz[a][b] = arquivo.getMatriz(a, b);
            }
        }
        boolean verif=false;
        int sort;
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.println("Qual o sort desejado?");
            System.out.println("Bubble:1/Insertion:2/Selection:3/Quick:4");
            
            sort = s.nextInt();
            if(sort==1||sort==2||sort==3||sort==4)
            {
                verif = true;
            }
            else{System.out.println("Opção invalida");}
                    
        }while(verif==false);
        int viz;
        Sort novoSort = new Sort();
        do
        {
            System.out.println("Qual a vizinhança desejada?");
            viz = s.nextInt();
            if(viz==3||viz==5||viz==7||viz==9||viz==13||viz==19||viz==25||viz==33||viz==49)
            {
                verif=false;
            }
        }while(verif == true);
        for(int a =0; a<nlinhas; a++)
        {
            for(int b =0; b<ncolunas; b++)
            {
                int [] subMatriz = arquivo.vizinhanca(a, b,viz);
                switch(sort)
                {
                    case 1:
                        matrizArranjada[a][b]= novoSort.bubbleSort(subMatriz,viz*viz);
                        break;
                    case 2:
                        matrizArranjada[a][b]= novoSort.insertionSort(subMatriz,viz*viz);
                        break;
                    case 3:
                        matrizArranjada[a][b]= novoSort.selectionSort(subMatriz,viz*viz);
                        break;
                    case 4:
                        matrizArranjada[a][b]= novoSort.quickSort(subMatriz,0,viz*viz);
                        
                }
            }
        }
        try
        {
            BufferedWriter out = new BufferedWriter(new FileWriter("Novo arquivo.txt"));
            out.write(arquivo.getNome());
            out.newLine();
            out.write(arquivo.nlinhas+" "+arquivo.ncolunas);
            out.newLine();
            out.write(arquivo.maxVal);
            out.newLine();
            for(int a=0;a<nlinhas;a++)
            {
                for(int b=0;b<ncolunas;b++)
                {
                    out.write(matrizArranjada[a][b]+" ");
                }
                out.newLine();
            }
            out.close();
       
        }
        catch(IOException e){System.out.println("Exeption");}
         end = System.currentTimeMillis();  
         diff = end - init;  
        System.out.println("Demorou " + (diff ) + " milisegundos segundos");
    }
}
