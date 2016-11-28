
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		String destino = args[0];
		leituraDosLivros teste = new leituraDosLivros(destino);
		formataSumario t1 = new formataSumario();
		
		t1.gravaNoArquivo(args[1], (teste.leTudo().positionsPre()));
		System.out.println("Gerando Sumário... ok");
		System.out.println("Imprimindo livro para o arquivo " + args[1]);
	

	}
}
