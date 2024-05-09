import CampoBatalla.CampoBatalla;
import Nivel.Nivel;

import java.util.Scanner;


public class main {
	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			// Mostrar el menú
			System.out.println("Menú:");
			System.out.println("1. Jugar nivel 1");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");

			// Leer la opción del usuario
			opcion = scanner.nextInt();

			// Manejar la opción seleccionada
			switch (opcion) {
				case 1:
					System.out.println("Seleccionaste la opción 1");
					CampoBatalla campoBatalla = new CampoBatalla(5,5);
					Nivel nivelUno = new Nivel(campoBatalla);
					nivelUno.jugarNivelUno();
					break;
				case 4:
					break;
				default:
					System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
			}
		} while (opcion != 4 && opcion != 1); // Repetir el menú hasta que el usuario seleccione la opción de salida
		scanner.close();

	}
}
