package backendjava.Modul4.MileStone1;

import java.util.ArrayList;
import java.util.Scanner;

//Classe amb metodes per facilitar entrada i control de dades per consola
public class Inputs {

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Metode que imprimeix linea a consola
	 */
	public static void displayLine() {
		System.out.println();
	}

	/**
	 * Metode per imprimir per consola text, s
	 * 
	 * @param s, String amb el text a mostrar per consola
	 */
	public static void displayLine(String s) {
		System.out.println(s);
	}

	/**
	 * Metode per treure per consola serie fibonacci
	 * 
	 * @param n, numero int d'entrada, entre 1 i 100
	 * 
	 */
	public static void fib(int n) {
		// Estadi inicial
		int previ = 0;
		int actual = 1;
		int seguent;

		for (int i = 1; i <= n; i++) {
			seguent = previ;
			previ = actual + previ;
			actual = seguent;

			System.out.print(actual + ", ");
		}

	}

	/**
	 * Metode per introduir per consola un nombre, text, passat per parametre
	 * 
	 * @param text, String
	 * @return inputText, String
	 */
	public static String introduirString(String text) {
		Scanner myObj = new Scanner(System.in);
		String inputText;

		// Introduir text i prem Enter
		System.out.println(text);
		inputText = myObj.nextLine();

		// Retornar string introduit
		return inputText;
	}

	/**
	 * Metode per introduir numero en rang correcte, entre 1 i 100
	 * 
	 * @param sc
	 * @param prompt
	 * @param min,   valor int minim del rang de valors
	 * @param max,   valor int maxim del rang de valors
	 * @return i, valor int en format i rang valid
	 */
	public static int getIntAmbRang(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(sc, prompt);
			if (i <= min) {
				System.out.println("----no valida, ha de ser igual o més gran que " + min);
			} else if (i > max) {
				System.out.println("----no valida, ha de ser menor o igual que " + max);

			} else {
				isValid = true;
			}

		}
		return i;
	}

	
	
	
	
	/**
	 * Metode per introduir numero en format correcte, numero en int
	 * 
	 * @param sc
	 * @param prompt text del prompt
	 * @return i, el valor int valid introduit per teclat a la consola
	 */
	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			// hasNextDouble, torna true si scanner contiene int
			if (sc.hasNextInt()) {
				// nextInt,
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("----Error! Entrada incorrecta, torna a provar.");
			}
			sc.nextLine();// Descartar aquesta linea introduida
		}
		return i;
	}

	/**
	 * Metode per introduir numero en format correcte, numero en int
	 * 
	 * @param sc
	 * @param prompt text del prompt
	 * @return i, el valor int valid entrat per teclat a la consola
	 */
	public static String introduirString(Scanner sc, String prompt) {
		String i = "";
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			// hasNextDouble, torna true si scanner contiene int
			if (sc.hasNext()) {
				// nextInt,
				i = sc.next();
				isValid = true;
			} else {
				System.out.println("----Text incorrecte!!");
			}
			sc.nextLine();// Descartar aquesta linea introduida
		}
		return i;
	}

	/**
	 * Metode per introduir string per teclat, captat per metode scanner, sc
	 * 
	 * @param prompt
	 * @return s, string entrat per teclat
	 */
	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.nextLine();
		return s;
	}

	/**
	 * Metode per introduir int en format correcte per teclat, captat per metode
	 * scanner, sc
	 * 
	 * @param prompt
	 * @return int, i entrat per teclat en format correcte
	 */

	public static int getInt(String prompt) {
		int i = 0;
		while (true) {
			System.out.print(prompt);
			try {
				i = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Error! Entrada incorrecta, torna a provar.");
			}
		}
		return i;
	}

	/**
	 * Metode per introduir double en format correte per teclat, captat per metode
	 * scanner, sc
	 * 
	 * @param prompt, String
	 * @return d, double
	 * @return d, string en format correcte
	 */

	public static double getDouble(String prompt) {
		double d = 0;
		while (true) {
			System.out.print(prompt);
			try {
				d = Double.parseDouble(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Error! Entrada incorrecta, torna a prova.");
			}
		}
		return d;

	}

	/**
	 * Metode per calcular i imprimir el nombre minim de bitllets que necessitem per
	 * pagar cost Formata correcte de cost es int, sense fraccions.
	 * 
	 * @param bitllets, array amb els diferents tipus de bitllets i monedes
	 *                  disponibles per pagar
	 * @param cost,     valor que s'ha optimitzar amb l'array dels bitllets i
	 *                  monedes
	 */
	public static void minBitllets(int bitllets[], double cost) {

		{
			// Inicialitzar resultat
			ArrayList<Integer> resultat = new ArrayList<Integer>();
			int n = bitllets.length;
			// Bucle pels tipus dels bitllets
			for (int i = n - 1; i >= 0; i--) {
				// Trobar els bitllets i afegir-los al resultat
				while (cost >= bitllets[i]) {
					cost = cost - bitllets[i];
					resultat.add(bitllets[i]);
				}
			}

			// Imprimir resultat
			for (int i = 0; i < resultat.size(); i++) {
				System.out.print(resultat.get(i) + "€,");
			}
			displayLine();
		}
	}

}