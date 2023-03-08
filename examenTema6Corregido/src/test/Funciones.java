package test;

import java.util.Arrays;
import java.util.Scanner;

public class Funciones {

	static String palabras[] = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };// guardara lista de palabras de las cuales se elegira una al azar para que el
									// jugador la adivine

	static final int NUMINTENTOS = 7;// almacenará el número de intentos que tiene el jugador para adivinar la
	// palabra. Inicialmente va a valer 7

	static String palabraSecreta = "";// almacenara la palabra a acertar

	static String palabraPista = "";// almacenará la pista del juego

	static String noAcertadas = "";// almacenara las letras no acertadas

	static void generaPalabra() {
		int posicionAleatoria = 0;

		posicionAleatoria = (int) (Math.random() * palabras.length);

		palabraSecreta = palabras[posicionAleatoria];

		for (int i = 0; i < palabraSecreta.length(); i++) {

			palabraPista += "_";
		}

	} // final funcion

	static int menu() {
		int opcionSeleccionada;

		Scanner dogma = new Scanner(System.in);

		System.out.println("Seleccione una de las siguientes opciones: \n1.Introducir letra.\n2.Introducir palabra.");
		opcionSeleccionada = dogma.nextInt();

		return opcionSeleccionada;
	}// final funcion

	static void comprobarLetra(String letra) {

		int posicionInicio = 0; // inicializada a 0

		int posicionFinal = palabraSecreta.indexOf(letra);// inicializada a posicion devuelta por busqueda

		String copiaPalabraPista = "";

		if (palabraSecreta.contains(letra)) {

			// si al entrar en funcion posicionFinal adquiere un valor igual o mayor a 0 es
			// porque ha encontrado la letra
			while (posicionFinal >= 0) {
				// Si está la letra construimos la pista
				// Hacemos un substring que contiene los guiones y a
				// continuación le añadimos la letra
				copiaPalabraPista += palabraPista.substring(posicionInicio, posicionFinal) + letra;

				// Actualizmos posInicio a la posición siguiente de la posición donde
				// se encontró la letra
				posicionInicio = posicionFinal + 1;

				// Volvemos a buscar la letra desde la posición siguiente
				// de donde la encontramos
				posicionFinal = palabraSecreta.indexOf(letra, posicionInicio);
				// si posicionFinal adquiere aqui un valor menor a 0 sera porque no ha
				// encontrado la letra asi que sale del bucle
			}

			// añade a copiaPalabraPista la subcadena desde la posicion devuelta por ultima
			// busqueda de letra hasta el final de la cadena palabraSecreta que es igual en
			// longitud a palabraPista esta subcadena contendra el resto de la palabraPista
			copiaPalabraPista += palabraPista.substring(posicionInicio, palabraSecreta.length());
			
			// ahora que yatenemos una copia con todas las letras en sus lugares damos
			// palabraPista valor igual a la cadena copiaPalabraPista
			palabraPista = copiaPalabraPista;

		} else {
			noAcertadas += letra;
		}
	}

	static void comprobarPalabra(String palabra) {
		if (palabraSecreta.equalsIgnoreCase(palabra)) {
			palabraPista = palabra;
		}
	}

	static void pintaPista() {
		System.out.println(palabraPista);
		System.out.println(noAcertadas);
	}

}