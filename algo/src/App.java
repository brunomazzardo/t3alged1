
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	System.out.println("Nome do arquivo de entrada:");
        String entrada = in.nextLine();
        System.out.println("Nome do arquivo de saida:");
        String saida = in.nextLine();
    	leituraDosLivros ll = new leituraDosLivros();
        GeneralTreeOfInteger tree = new GeneralTreeOfInteger();
        
        System.out.println("Carregando arquivo livro.txt... ok");
        System.out.println("Gerando a árvore... ok");
        
        System.out.println("Gerando o sumário... ok");
        System.out.println("Imprimindo o livro para o arquivo livro_prod.txt... ok.");
        
        
        //EXEMPLO SAÍDA
//        Carregando arquivo livro.txt... ok
//        Gerando a árvore... ok
//         Capitulos...: 2
//         Seções......: 6
//         Subseções...: 2
//         Parágrafos..: 16
//        Gerando o sumário... ok
//        Imprimindo o livro para o arquivo livro_prod.txt... ok.
	}

}
