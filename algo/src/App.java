
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
        System.out.println("Gerando a �rvore... ok");
        
        System.out.println("Gerando o sum�rio... ok");
        System.out.println("Imprimindo o livro para o arquivo livro_prod.txt... ok.");
        
        
        //EXEMPLO SA�DA
//        Carregando arquivo livro.txt... ok
//        Gerando a �rvore... ok
//         Capitulos...: 2
//         Se��es......: 6
//         Subse��es...: 2
//         Par�grafos..: 16
//        Gerando o sum�rio... ok
//        Imprimindo o livro para o arquivo livro_prod.txt... ok.
	}

}
