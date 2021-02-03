package backendjava.Modul4.MileStone3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MileStone3 {

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
		int opcioComanda = 1;

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
				try {

					// Introduir plat
					String nomPlat = Inputs.getString("	-->Introdueix nom del plat? ");
					if (nomPlat == null || nomPlat.isEmpty()) {
						// Llençar excepció si nomPlat es null o està buit
						throw new EntradaBuidaException("El nom no pot quedar buit");
					}

					// Comprovar si existeix el plat introduit

					if (CrearMap.compararPlat(menuMap, nomPlat) == true) {
						// Llençar excepció si el nom del plat ja existeix al menu
						throw new PlatExisteixException("Error! El plat ja existeix al menu");
					} else {

						Integer preuPlat = Inputs.getInt("	-->Introdueix preu del plat?");

						menuMap.put(nomPlat, preuPlat);

						Inputs.displayLine("	" + nomPlat + " , afegit al menu");
						Inputs.displayLine();
					}
				} catch (EntradaBuidaException e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				} // Tractar excepcio, nom del plat buit
					// Tractar excepcio, no existeix el plat al menu
				catch (PlatExisteixException e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				}

				catch (Exception e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				} catch (Throwable e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				}
				Inputs.displayLine();
				while (true) {
					try {

						opcioMenu = Inputs.getString(" Vols crear una altre plat? (S/N): ");

						if (opcioMenu.equalsIgnoreCase("S") || opcioMenu.equalsIgnoreCase("N")) {
							break;
						}
						if (opcioMenu.isEmpty()) {
							throw new EntradaBuidaException("Error! La opcio no pot quedar buida.");
						} else {
							throw new EntradaStringException("Error!. Entrada no valida.");
						}

					}

					// Tractar excepcio, nom del plat buit
					catch (EntradaBuidaException e) {
						Inputs.displayLine();
						Inputs.displayLine(e.getMessage());
					}

					// Tractar excepcio, error string introduit
					catch (EntradaStringException e) {
						Inputs.displayLine();
						Inputs.displayLine(e.getMessage());
					}
					/*
					 * // Tractar excepcio, error a entrada y/n catch (EntradaYesNoException e) {
					 * Inputs.displayLine(); Inputs.displayLine(e.getMessage()); }
					 */ catch (Exception e) {
						Inputs.displayLine();
						Inputs.displayLine(e.getMessage());
					} catch (Throwable e) {
						Inputs.displayLine();
						Inputs.displayLine(e.getMessage());
					}

					Inputs.displayLine();
				}
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
				try {
					// Introduir plats de comanda
					// String inputPlat = Inputs.introduirString(" -->Introdueix nom del plat? ");
					String inputPlat = Inputs.getString("	-->Introdueix nom del plat? ");
					// Comprovar si existeix el plat introduit

					if (menuMap.containsKey(inputPlat)) {

						totalComanda = totalComanda + menuMap.get(inputPlat);
						// Afegim el plat a la comanda
						platsComanda.add(inputPlat);
						Inputs.displayLine("	--->Plat  " + inputPlat + " afegit a la comanda.(Preu unitat= "
								+ menuMap.get(inputPlat) + " €). Total Comanda " + totalComanda + " €");

					} else {
						//
						if (inputPlat == null || inputPlat.isEmpty()) {
							// Llençar excepció si nomPlat es null o està buit
							throw new PlatNoExisteixException("Error!!! Introdueix un nom");
						} else {
							throw new PlatNoExisteixException("Error! El plat " + inputPlat + " no existeix al menu");

						}
					}

					while (true) {
						opcioComanda = Inputs.getInt("---Vols demanar més plats? (1:Si/0:No): ");

						if (opcioComanda == 1 || opcioComanda == 0) {
							break;
						} else {
							throw new OpcioContinuarComandaException("Error!. Entrada no valida. Torna a provar");
						}

					}

					Inputs.displayLine();
				}
				// Tractar PlatNoExisteixException, si el nom no esta al menu
				catch (PlatNoExisteixException e) {
					Inputs.displayLine(e.getMessage());
				}
				// Tractar OpcioContinuarComandaException, si el nom esta buit
				catch (OpcioContinuarComandaException e) {
					Inputs.displayLine(e.getMessage());

				} // Tractar excepcio, nom del plat buit
				catch (EntradaIntException e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				} catch (Exception e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				} catch (Throwable e) {
					Inputs.displayLine();
					Inputs.displayLine(e.getMessage());
				}

			}
			opcio = "N";
			if (totalComanda >= 0) {
				Inputs.displayLine("---Plats de la comanda---");
				System.out.println(platsComanda + " total a pagar " + totalComanda + " €");

				Inputs.displayLine("---Pagar comanda---");
				System.out.print("Nombre minim de bitllets i monedes amb que pots pagar: ");
				// Imprimir nombre minimi de bitllets i monedes a pagar
				Inputs.minBitllets(bitlletsMonedes, totalComanda);
			}
			sc.close();
			Inputs.displayLine();
			Inputs.displayLine("---Adeu!!");

		}
	}
}
