package CampoBatalla;

import java.util.ArrayList;
import Coordenada.Coordenada;


public class CampoBatalla {

	private Integer tamanioX;
	private Integer tamanioY;
	private ArrayList<Coordenada> tablero;
	//private ArrayList<Coordenada> tirosDados;
	private Coordenada disparo;

	public CampoBatalla(Integer tamanioX, Integer tamanioY){
		this.tamanioX = tamanioX;
		this.tamanioY = tamanioY;
		tablero = new ArrayList<Coordenada>();
		//tirosDados = new ArrayList<Coordenada>();
	}

	public void generarTablero(){
		for (int i = 0; i < tamanioX; i++) {
			for (int j = 0; j < tamanioY; j++) {
				tablero.add(new Coordenada(i,j));
			}
		}
	}

	public void mostrarTablero() {
		// Mostrar índices de las columnas
		System.out.print("  ");
		for (int j = 0; j < tamanioY; j++) {
			System.out.print(j + 1 + " ");
		}
		System.out.println();

		// Mostrar el tablero con índices de las filas
		for (int i = 0; i < tamanioX; i++) {
			System.out.print(i + 1 + " "); // Índice de la fila
			for (int j = 0; j < tamanioY; j++) {
				boolean encontrado = false;
				for (Coordenada coord : tablero) {
					if (coord.getCoordX() == i && coord.getCoordY() == j) {
						encontrado = true;
						if(coord.getBarco() == null){
							System.out.print("- "); // Si hay un barco en null, imprimir "-" seria el agua
							break;
						}else{
							System.out.print("1 "); // Si hay una coordenada en esta posición, imprimir "1"
							break;
						}
					}
				}
				if (!encontrado) {
					System.out.print("0 "); // Si no hay una coordenada en esta posición, imprimir "0"
				}
			}
			System.out.println();
		}
	}




}
