package backendjava.Modul4.MileStone2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import backendjava.Modul4.MileStone1.Inputs;

public class CrearMap {

	/**
	 * Metode girarArray passat per parametre
	 */
	public static ArrayList<Character> girarArray(ArrayList<Character> inputArrayList) {
		// Crear una lista vacia de caracteres
		ArrayList<Character> miListaCaracters = new ArrayList<>();

		// Tornem la llista de caracters
		return miListaCaracters;

	}

	/**
	 * Metode que passa el text dins la variable nomComplet a array de caracters i
	 * els mostra per pantalla
	 * 
	 * @author
	 * @param String text
	 * @return ArrayList<Character> miListaCaracters
	 */
	public static ArrayList<Character> convertirStringAListChar(String text) {

		// Crear una lista vacia de caracteres
		ArrayList<Character> miListaCaracters = new ArrayList<>(text.length());

		// Bucle que recorre tot l'string text i afegeix cada caracter a la llista
		for (char ocurrencia : text.toCharArray()) {
			miListaCaracters.add(ocurrencia);

		}
		// Tornem la llista de caracters
		return miListaCaracters;

	}

	/**
	 * Metode per convertir string en array de chars
	 * 
	 * @param text, string a convertir en Array de chars
	 */
	public static void convertirTextEnArrayDeChars(String text) {
		char[] arrayChars = text.toCharArray();

		for (char ocurrencia : arrayChars) {
			System.out.println(ocurrencia);

		}

	}

	/**
	 * Metode per introduir per consola un nombre, num, de ciutats passat per
	 * parametre
	 * 
	 * @param int num
	 * @return String inputText
	 */
	static String generarArray(int num) {

		Scanner myObj = new Scanner(System.in);
		String inputText;

		// Enter ciutat and press Enter
		System.out.println("Introdueix Ciutat (" + num + ")");
		inputText = myObj.nextLine();

		// retornem string introduit
		return inputText;
	}

	/**
	 * Metode per introduir per consola un nombre, num, de ciutats passat per
	 * parametre
	 * 
	 * @param int num
	 * @return String inputText
	 */
	static String introduirCiutat(int num) {
		Scanner myObj = new Scanner(System.in);
		String inputText;

		// Enter ciutat and press Enter
		System.out.println("Introdueix Ciutat (" + num + ")");
		inputText = myObj.nextLine();
		myObj.close();
		// retornem string introduit
		return inputText;
	}

	/**
	 * Metode per introduir per consola un nombre, num, de ciutats passat per
	 * parametre
	 * 
	 * @param int num
	 * @return String inputText
	 */
	static int introduirInt(String text, int rangmin, int rangmax) {
		Scanner myObj = new Scanner(System.in);

		// Enter ciutat and press Enter
		System.out.println(text);
		// inputText = myObj.nextLine();
		int num = Inputs.getIntAmbRang(myObj, text, rangmin, rangmax);
		// retornem string introduit
		return num;
	}

	/**
	 * 
	 * @param mapa, HashMap<String, Integer>
	 * @param text, String
	 * @return
	 */
	static Boolean compararPlat(HashMap<String, Integer> mapa, String text) {

		boolean existeix = true;
		// Iterar entre les key,value del map
		for (HashMap.Entry m : ((HashMap<String, Integer>) mapa).entrySet()) {

			// Mirar si el menu insertat esta al menu
			if (mapa.containsKey(text)) {
				existeix = true;
			} else {
				existeix = false;
			}

		}
		return existeix;
	}

	/**
	 * Imprimir HasMap key és String, value Integer preu del plat
	 * 
	 * @param mapa
	 * 
	 */
	static void imprimirMap(HashMap<String, Integer> mapa) {

		for (HashMap.Entry m : ((HashMap<String, Integer>) mapa).entrySet()) {

			System.out.println("	Plat: " + m.getKey() + "  Preu = " + m.getValue() + "€");
		}
		System.out.println("	--------------");

	}

	/**
	 * Metode per inicialitzar menu amb 4 plats
	 * 
	 * @return map, HashMap<String, Integer>, key String amb nom dels plats, value
	 *         integer amb el preu de cada plat
	 */
	public static HashMap<String, Integer> initMenu() {
		// Inicialitzem menu amb 4 plats i els seus preus
		// Inicialitzar el hashmap
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// Assignar cada plat amb key, i value es preu de cada plat
		map.put("Canalons", 6);
		map.put("Paella", 11);
		map.put("Patates amb llom", 6);
		map.put("Amanida", 5);
		map.put("Dorada a la sal", 12);

		return map;
	}

	/**
	 * Metode per introduir per consola un nombre, num, de ciutats passat per
	 * parametre
	 * 
	 * @param int num
	 * @return String inputText
	 */
	static String introduirString(String text) {
		Scanner myObj = new Scanner(System.in);
		String inputText;

		// Enter ciutat and press Enter
		System.out.println(text);
		inputText = myObj.nextLine();

		// retornem string introduit
		return inputText;
	}

	/**
	 * Metode que substituir les "a" de les ciutats guardades per "4" i retornar-ho
	 * en un ArrayList
	 * 
	 * @param ArrayList<String> ciutats
	 * @return ArrayList<String> substituirAs
	 * 
	 */

	static ArrayList<String> substituirA(ArrayList<String> ciutats) {
		ArrayList<String> substituirAs = new ArrayList<String>();
		for (String i : ciutats) {

			i = i.replaceAll("a", "4");
			substituirAs.add(i);

		}

		return substituirAs;

	}
}
