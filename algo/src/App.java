
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		leituraDosLivros teste = new leituraDosLivros();
		
		formataSumario t1=new formataSumario();
		System.out.println(t1.sb(teste.leTudo().positionsPre()).toString());


	}
}
