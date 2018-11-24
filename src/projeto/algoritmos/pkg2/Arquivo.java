package projeto.algoritmos.pkg2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Arquivo 
{
    int matriz[][];
    int nlinhas, ncolunas;
    String nome, maxVal;
    public void copiaArquivo()
    {
        try     
        {
            FileReader     i  = new FileReader("Lena.pgm");
            BufferedReader in = new BufferedReader(i);
            String linha;
            nome = in.readLine();
            linha = in.readLine();
            maxVal =in.readLine();
            String tamanho[] = linha.split(Pattern.quote(" "));
            nlinhas = Integer.parseInt(tamanho[0]);
            ncolunas = Integer.parseInt(tamanho[1]);
            matriz = new int[nlinhas][ncolunas];
            int valores [] = new int [nlinhas*ncolunas];
            int aux2 = 0;
            while ((linha = in.readLine()) != null)
            {
                    String numero [] = linha.split(Pattern.quote(" "));
                    for(int aux = 0;  aux<numero.length; aux++)
                    {
                        valores [aux2] = Integer.parseInt(numero[aux]);
                        aux2++;
                    }
            }
            int aux = 0;
            for(int a =0; a<nlinhas; a++)
            {
                for(int b =0; b<ncolunas; b++)
                {
                    matriz[a][b] = valores[aux];
                    aux++;
                }
            }
        }catch (Exception e){System.out.println("Exeption");}   
    }
    public String getNome()
    {
        return nome;
    }
    public String maxVal()
    {
        return maxVal;
    }
    public int getMatriz(int linha, int coluna)
    {
       return matriz[linha][coluna];
    }
    public int getColuna()
    {
        return ncolunas;
    }
    public int getLinha()
    {
        return nlinhas;
    }
    public int[] vizinhanca(int nlinha, int ncoluna, int tamanhoviz)
    {
        int subMatriz [] = new int [tamanhoviz*tamanhoviz];
        int recuo = 0;
        switch (tamanhoviz)
        {
            case 3:
                recuo = -1;
                break;
            case 5:
                recuo = -2;
                break;
            case 7:
                recuo = -3;
                break;
            case 9:
                recuo = -4;
                break;
            case 13:
                recuo =-6;
                break;
            case 19:
                recuo =-9;
                break;
            case 25:
                recuo =-12;
                break;
            case 33:
                recuo =-16;
                break;
            case 49:
                recuo=-24;
                break;
        }
        int aux = recuo;
        int cont=0;
        for(int a = 0; a<tamanhoviz; a++)
            {
                int aux2 = recuo;
                for(int b = 0; b < tamanhoviz; b++)
                {
                    if (ncoluna+aux2<0|| ncoluna+aux2>=ncolunas||nlinha+aux<0||nlinha-aux>=nlinhas)
                    {
                        for(int c = 0; a< tamanhoviz*tamanhoviz; a++)
                        {
                            subMatriz[c] = 0;
                        }
                        return subMatriz;
                    }
                    else
                    {
                        subMatriz[cont]= matriz[nlinha+aux][ncoluna+aux2];
                        aux2++;
                        cont++;
                    }
                }
                aux++;
            }
        return subMatriz;
    }
}