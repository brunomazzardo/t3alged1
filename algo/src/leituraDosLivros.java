import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class leituraDosLivros {

	public void leTudo() {
		ArrayList<String> livroArray = new ArrayList<>();

		Path c1 = FileSystems.getDefault().getPath("Livros", "livro.txt");
		BufferedReader leitor;
		try {
			leitor = Files.newBufferedReader(c1, Charset.defaultCharset());

			String linha;
			while ((linha = leitor.readLine()) != null) {
				Scanner sc = new Scanner(linha);
				if (linha.substring(0, 1).equals("L") || linha.substring(0, 1).equals("C")
						|| linha.substring(0, 1).equals("S")) {
					livroArray.add(linha.substring(2, linha.length()));//
				}
			}

		} catch (IOException e) {
			System.out.println("Livro não encontrado");
			e.printStackTrace();
		}
	}

}
