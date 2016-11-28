
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class formataSumario {
	private ArrayList<String> sumario = new ArrayList<>();

	public ArrayList<String> sb(ArrayList<String> copiaLivro) {
		ArrayList<String> sb = new ArrayList<>();
		boolean restaLinha = false;
		int nLinha = 0;
		int atu = 0;
		int numPagina = 0;
		int aux1 = 0;
		int aux2 = 0;
		int aux3 = 0;
		sb.add("------------------------------------------");
		for (int r = 1; r <= 15; r++) {

			if (r == 7) {

				sb.add(r + "                " + copiaLivro.get(0).substring(2, copiaLivro.get(0).length()));

				copiaLivro.remove(0);
				r++;
			}
			sb.add(r + " ");
		}
		sb.add("------------------------------------------  Capa");

		while (copiaLivro.size() > 0) {
			numPagina++;
			for (int i = 1; i <= 15; i++) {
				String linha = null;
				if (restaLinha) {
					for (int l = 1; l < nLinha; l++) {
						if (i > 14)
							break;
						atu++;
						linha = "   Lorem Ipsum " + atu;
						sb.add(i + " " + linha);

						i++;

					}

				}
				atu = 0;
				nLinha = 0;

				if (copiaLivro.size() < 1)
					break;
				if (copiaLivro.get(0).substring(0, 1).equals("C")) {
					if(i>1){
						sb.add("------------------------------------------  Pg. " + numPagina);
						numPagina++;
						i=1;
					}
						
					aux2 = 0;
					aux3 = 0;

					aux1++;
					linha = aux1 + ". " + copiaLivro.get(0).substring(2, copiaLivro.get(0).length());
					copiaLivro.remove(copiaLivro.get(0));
					sb.add(i + " " + linha);

					sumario.add(linha + "....................... " + numPagina);
				

				} else if (copiaLivro.get(0).substring(0, 2).equals("S ")) {
					aux2++;
					linha = aux1 + "." + aux2 + " " + copiaLivro.get(0).substring(2, copiaLivro.get(0).length());
					copiaLivro.remove(copiaLivro.get(0));
					sb.add(i + " " + linha);

					sumario.add(linha + "....................... " + numPagina);
					

				} else if (copiaLivro.get(0).substring(0, 2).equals("SS")) {
					aux3++;
					linha = aux1 + "." + aux2 + "." + aux3 + " "
							+ copiaLivro.get(0).substring(2, copiaLivro.get(0).length());
					copiaLivro.remove(copiaLivro.get(0));
					sb.add(i + " " + linha);

					sumario.add(linha + "......................." + numPagina);
					

				} else if (copiaLivro.get(0).substring(0, 1).equals("P")) {
					for (int c = 0; c < Integer
							.parseInt(copiaLivro.get(0).substring(2, copiaLivro.get(0).length())); c++) {
						atu++;
						linha = "   Lorem Ipsum " + atu;
						sb.add(i + " " + linha);

						i++;

						if (i > 15) {
							restaLinha = true;
							nLinha = Integer.parseInt(copiaLivro.get(0).substring(2, 3)) - c;
							c = Integer.parseInt(copiaLivro.get(0).substring(2, 3));
						}
					}
					copiaLivro.remove(copiaLivro.get(0));
					i--;
				}
			}

			sb.add("------------------------------------------  Pg. " + numPagina);

		}
		return sb;
	}

	public void gravaNoArquivo(String destino, ArrayList<String> semFormatação) {
		ArrayList<String> formatado = new ArrayList<>(sb(semFormatação));
		try {
			PrintWriter imprimi = new PrintWriter(destino);
			for (int i = 0; i < formatado.size(); i++) {
				imprimi.println(formatado.get(i));

			}
			imprimi.println("SUMÁRIO");
			for(int j=0;j<sumario.size();j++){
				imprimi.println(sumario.get(j));
				
			}

			
			imprimi.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo Não Encontrado");
			e.printStackTrace();
		}

	}
}
