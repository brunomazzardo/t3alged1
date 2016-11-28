
import java.util.ArrayList;

public class formataSumario {

	public formataSumario() {

	}

	public StringBuilder sb(ArrayList<String> copiaLivro) {
		StringBuilder sb = new StringBuilder();
		boolean restaLinha = false;
		int nLinha = 0;

		int aux1 = 0;
		int aux2 = 0;
		int aux3 = 0;

		sb.append("--------------------------------------------");
		sb.append("\n");
		sb.append(copiaLivro.get(0).substring(2, copiaLivro.get(0).length()));
		sb.append("\n");
		copiaLivro.remove(0);

		while (copiaLivro.size() > 0) {
			for (int i = 1; i <= 15; i++) {
				String linha = null;
				if (restaLinha) {
					for (int l = 0; l < nLinha; l++) {
						int atu=l+1;
						linha = " Lorem Ipsum"+atu;
						sb.append(i + " " + linha);
						sb.append("\n");
						i++;
					}
				}
				if (copiaLivro.size() < 1)
					break;

				if (copiaLivro.get(0).substring(0, 1).equals("C")) {
					aux1++;
					linha = aux1 + ". " + copiaLivro.get(0).substring(2, copiaLivro.get(0).length());
					copiaLivro.remove(copiaLivro.get(0));
					sb.append(i + " " + linha);
					sb.append("\n");

				}

				else if (copiaLivro.get(0).substring(0, 2).equals("S ")) {
					aux2++;
					linha = aux1 + "." + aux2 + " " + copiaLivro.get(0).substring(2, copiaLivro.get(0).length());

					copiaLivro.remove(copiaLivro.get(0));
					sb.append(i + " " + linha);
					sb.append("\n");
				}

				else if (copiaLivro.get(0).substring(0, 2).equals("SS")) {
					aux3++;
					linha = aux1 + "." + aux2 + "." + aux3 + " "
							+ copiaLivro.get(0).substring(2, copiaLivro.get(0).length());

					copiaLivro.remove(copiaLivro.get(0));
					sb.append(i + " " + linha);
					sb.append("\n");

				} else if (copiaLivro.get(0).substring(0, 1).equals("P")) {
					for (int c = 0; c < Integer.parseInt(copiaLivro.get(0).substring(2, 3)); c++) {
						int atu=c+1;
						linha = "Lorem Ipsum " + atu;
						sb.append(i + " " + linha);
						sb.append("\n");
						i++;
						if (i > 15) {
							restaLinha = true;
							nLinha = Integer.parseInt(copiaLivro.get(0).substring(2, 3)) - c;

							c = Integer.parseInt(copiaLivro.get(0).substring(2, 3)) - c;

							i = 16;
						}

					}
					copiaLivro.remove(copiaLivro.get(0));

				}

			}

		}
		return sb;

	}
}
