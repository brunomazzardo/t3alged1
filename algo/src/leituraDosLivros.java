import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class leituraDosLivros {
	private String destino;
	private int nCapitulos = 0;
	private int NSeções = 0;
	private int Ss = 0;
	private int paragrafos = 0;

	public leituraDosLivros(String destino) {
		this.destino = destino;

	}

	public GeneralTreeOfString leTudo() {
		String Capitulo = "Oi";
		boolean para = false;
		GeneralTreeOfString arvLivro = new GeneralTreeOfString();
		String seção = "09";
		ArrayList<String> copiaLivro = le1();
		arvLivro.add(copiaLivro.get(0), null);
		for (int i = 1; i < copiaLivro.size();) {
			para = false;
			if (copiaLivro.get(i).substring(0, 1).equals("C")) {
				Capitulo = copiaLivro.get(i);
				arvLivro.add(Capitulo, arvLivro.getRoot());
				i++;
				nCapitulos++;
			}
			if (copiaLivro.get(i).substring(0, 2).equals("S ")) {
				seção = copiaLivro.get(i);
				arvLivro.add(seção, Capitulo);
				i++;
				NSeções++;
			}
			if (i > copiaLivro.size())
				break;
			while (!para) {
				if (i >= copiaLivro.size())
					break;
				if (copiaLivro.get(i).substring(0, 2).equals("SS")) {
					arvLivro.add(copiaLivro.get(i), seção);
					seção = copiaLivro.get(i);
					i++;
					Ss++;
				} else if (copiaLivro.get(i).substring(0, 1).equals("P")) {
					arvLivro.add(copiaLivro.get(i), seção);
					i++;
					paragrafos++;
				} else {
					para = true;
				}
			}
		}
		System.out.println("Gerando a árvore... ok");
		System.out.println("Capitulos..."+nCapitulos);
		System.out.println("Seções... "+ NSeções);
		System.out.println("Subseções... "+ Ss);
		System.out.println("Parágrafos..."+ paragrafos);
		return arvLivro;
	}

	public ArrayList<String> le1() {

		ArrayList<String> le1 = new ArrayList<>();
		Path c1 = FileSystems.getDefault().getPath(destino);
		BufferedReader leitor;
		try {
			leitor = Files.newBufferedReader(c1, Charset.defaultCharset());
			System.out.println("Carregando arquivo " + destino + " ...  ok");

			String linha = "oi";

			while ((linha = leitor.readLine()) != null) {

				le1.add(linha);

			}

		} catch (Exception e) {

		}

		return le1;

	}

}
