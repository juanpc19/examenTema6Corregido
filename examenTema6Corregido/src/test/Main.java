package test;

import java.util.Scanner;

import test.Funciones;

public class Main {

	public static void main(String[] args) {

		String palabraUsuario = "";

		String letraUsuario = "";

		int seleccion;

		Scanner dogma = new Scanner(System.in);

		Funciones.generaPalabra();

		System.out.println(Funciones.palabraPista);

		System.out.println(Funciones.palabraSecreta);

		do {

			seleccion = Funciones.menu();

			switch (seleccion) {

			case 1 -> {
				System.out.println("Introduzca una letra: ");
				letraUsuario = dogma.nextLine();
				letraUsuario = letraUsuario.toLowerCase();
				Funciones.comprobarLetra(letraUsuario);
			}

			case 2 -> {
				System.out.println("Introduzca una palabra: ");
				palabraUsuario = dogma.nextLine();
				palabraUsuario = palabraUsuario.toLowerCase();
				Funciones.comprobarPalabra(palabraUsuario);
			}

			default -> {
				System.out.println("Asegurese de seleccionar 1 o 2. ");
			}
			}

			Funciones.pintaPista();

			System.out.println("Le quedan: " + (Funciones.NUMINTENTOS - Funciones.noAcertadas.length()) + " intentos.");

		} while (!Funciones.palabraSecreta.equalsIgnoreCase(palabraUsuario)
				&& (Funciones.NUMINTENTOS > Funciones.noAcertadas.length()));

		if (Funciones.NUMINTENTOS <= Funciones.noAcertadas.length()) {
			System.out.println("GAME OVER");

		} else {
			System.out.println("¡¡ENHORABUENA!! HAS ACERTADO.");
		}

		dogma.close();

	}
}
