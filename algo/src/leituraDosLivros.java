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

	public GeneralTreeOfString leTudo() {
		String Capitulo = "Oi";
		boolean para = false;
		GeneralTreeOfString arvLivro = new GeneralTreeOfString();
		String seção = "09";
		ArrayList<String> copiaLivro = le1();
		arvLivro.add(copiaLivro.get(0), null,5);
		for (int i = 1; i < copiaLivro.size();) {
			para = false;
			if (copiaLivro.get(i).substring(0, 1).equals("C")) {
				Capitulo = copiaLivro.get(i);
				arvLivro.add(Capitulo, arvLivro.getRoot(),0);
				i++;
			}
			if (copiaLivro.get(i).substring(0, 2).equals("S ")) {
				seção = copiaLivro.get(i);
				arvLivro.add(seção, Capitulo,1);
				i++;
			}
			if (i > copiaLivro.size())
				break;
			while (!para) {
				if (i >= copiaLivro.size())
					break;
				if (copiaLivro.get(i).substring(0, 2).equals("SS")) {
					arvLivro.add(copiaLivro.get(i), seção,2);
					seção = copiaLivro.get(i);
					i++;
				} else if (copiaLivro.get(i).substring(0, 1).equals("P")) {
					arvLivro.add(copiaLivro.get(i), seção,3);
					i++;
				} else {
					para = true;
				}
			}
		}

		return arvLivro;
	}


	public ArrayList<String> le1() {

		ArrayList<String> le1 = new ArrayList<>();
		Path c1 = FileSystems.getDefault().getPath("livros", "livro.txt");
		BufferedReader leitor;
		try {
			leitor = Files.newBufferedReader(c1, Charset.defaultCharset());

			String linha = "oi";

			while ((linha = leitor.readLine()) != null) {

				le1.add(linha);

			}

		} catch (Exception e) {

		}

		return le1;

	}

}
