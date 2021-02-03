package backendjava.Modul4.MileStone1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import backendjava.Modul4.MileStone2.Inputs;

public class MileStone1 {

	public static void main(String args[]) {
		// Crear array de int amb els diferents bitllets i monedes disponibles per pagar
		final int bitlletsMonedes[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		// Crear HashMap menuMap
		HashMap<String, Integer> menuMap = new HashMap<String, Integer>();
		// Crear ArrayList amb els plats de la comanda
		ArrayList<String> platsComanda = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		String opcio = "S";
		String opcioMenu = "S";
		Integer opcioComanda = 1;

		while (opcio.equalsIgnoreCase("S")) {
			/*
			 * Inputs classe del packet amb diferents metodes per imprimir per consola i
			 * capturar entrades per teclat
			 */
			Inputs.displayLine();
			Inputs.displayLine("	----MENU----");
			// CrearMap clase del packet per treballar amb Maps
			menuMap = CrearMap.initMenu();
			CrearMap.imprimirMap(menuMap);
			Inputs.displayLine();
			Inputs.displayLine("Afegeix plats nous al menu");
			while (opcioMenu.equalsIgnoreCase("S")) {

				// Introduir plat
				String nomPlat = Inputs.getString("	-->Introdueix nom del plat? ");

				int preuPlat = Inputs.getIntAmbRang(sc, "	-->Introdueix preu del plat? ", 1, 100);

				// Comprovar si existeix el plat introduit
				if (CrearMap.compararPlat(menuMap, nomPlat) == true) {

					Inputs.displayLine("	El plat:" + nomPlat + " ja està al menu");
				} else {
					// Afegir al HashMap, nomPlat com key i el preuPlat com value

					menuMap.put(nomPlat, preuPlat);

					Inputs.displayLine("	" + nomPlat + " , afegit al menu");
					Inputs.displayLine();
				}
				Inputs.displayLine();

				while (true) {
					Inputs.displayLine("	Vols crear una altre plat? (S/N): ");
					opcioMenu = sc.nextLine();

					if (opcioMenu.equalsIgnoreCase("S") || opcioMenu.equalsIgnoreCase("N")) {
						break;
					}
					if (opcioMenu.isEmpty()) {
						Inputs.displayLine("Error! El nom no pot quedar buit. Torna a provar");
					} else {
						Inputs.displayLine("Error!. Entrada no valida. Torna a provar");
					}

				}
				Inputs.displayLine();
			}

			// Imprimir menu amb els nous plats
			Inputs.displayLine("	----MENU----");
			CrearMap.imprimirMap(menuMap);
			Inputs.displayLine();
			Inputs.displayLine();

			// Realitzar comanda
			Inputs.displayLine("Realitza comanda----");
			double totalComanda = 0;
			while (opcioComanda != 0) {

				// Introduir plats de comanda
				String inputPlat = Inputs.introduirString("	-->Introdueix nom del plat? ");

				// Comprovar si existeix el plat introduit
				if (menuMap.containsKey(inputPlat)) {

					totalComanda = totalComanda + menuMap.get(inputPlat);
					// Afegim el plat a la comanda
					platsComanda.add(inputPlat);
					Inputs.displayLine("	--->Plat  " + inputPlat + " afegit a la comanda.(Preu unitat= "
							+ menuMap.get(inputPlat) + " €). Total Comanda " + totalComanda + " €");

				} else {

					Inputs.displayLine("	--->Plat  " + inputPlat + " no existeix al menu");
				}

				while (true) {
					opcioComanda = Inputs.getInt("---Vols demanar més plats? (1:Si/0:No): ");

					if (opcioComanda == 1 || opcioComanda == 0) {
						break;
					} else {
						Inputs.displayLine("Error!. Entrada no valida. Torna a provar");
					}

				}

				Inputs.displayLine();
			}
			opcio = "N";
			if (totalComanda >= 0) {
				Inputs.displayLine("---Plats de la comanda---");
				System.out.println(platsComanda + " total a pagar " + totalComanda + " €");

				Inputs.displayLine("---Pagar comanda---");
				System.out.print("Nombre minim de bitllets i monedes amb que pots pagar: ");
				// Imprimir nombre minim de bitllets i monedes a pagar
				Inputs.minBitllets(bitlletsMonedes, totalComanda);
			}
			sc.close();
			Inputs.displayLine();
			Inputs.displayLine("---Adeu!!");
		}
	}
}
