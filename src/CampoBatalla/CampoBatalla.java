package CampoBatalla;

import java.util.ArrayList;

import Barco.Barco;
import Barcos.BarcoBatalla;
import Coordenada.Coordenada;


public class CampoBatalla {

	private final Integer tamanioX;
	private final Integer tamanioY;
	private final ArrayList<Coordenada> tablero;
	//private ArrayList<Barco> listaBarcos;
	//private ArrayList<Coordenada> tirosDados;
	//private Coordenada disparo;

	public CampoBatalla(Integer tamanioX, Integer tamanioY){
		this.tamanioX = tamanioX;
		this.tamanioY = tamanioY;
		tablero = new ArrayList<Coordenada>();
		//listaBarcos = new ArrayList<Barco.Barco>();
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
			System.out.print(j + " ");
		}
		System.out.println();

		// Mostrar el tablero con índices de las filas
		for (int i = 0; i < tamanioX; i++) {
			System.out.print(i + " "); // Índice de la fila
			for (int j = 0; j < tamanioY; j++) {
				boolean encontrado = false;
				for (Coordenada coord : tablero) {
					if (coord.getCoordX() == i && coord.getCoordY() == j) {
						encontrado = true;
						if(coord.getBarco() == null){
							System.out.print("- "); // Si hay un barco en null, imprimir "-" seria el agua
							break;
						} else if (coord.getBarco() instanceof BarcoBatalla) {
							System.out.print("B "); // Si hay un barco en null, imprimir "-" seria el agua
							break;
						} else{
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

	public void agregarBarco(Barco barco){
		boolean verificador = false;
		if (barco.getDireccion()){//vertical
			for (int i = barco.getCoordenada().getCoordX(); i <= barco.getCoordenada().getCoordX() + barco.getTamanio(); i++) {
				for (int j = barco.getCoordenada().getCoordY(); j == barco.getCoordenada().getCoordY() ; j++) {
					for (Coordenada coor : tablero){
						if (coor.getCoordX().equals(i) &&
						coor.getCoordY().equals(j) && coor.getBarco() == null){
							coor.setBarco(barco);
						}
					}
				}
			}
		}else{//horizontal
			for (int i = barco.getCoordenada().getCoordX(); i == barco.getCoordenada().getCoordX(); i++) {
				for (int j = barco.getCoordenada().getCoordY(); j <= barco.getCoordenada().getCoordY() + barco.getTamanio() ; j++) {
					for (Coordenada coor : tablero){
						if (coor.getCoordX().equals(i) &&
								coor.getCoordY().equals(j) && coor.getBarco() == null){
							coor.setBarco(barco);
						}
					}
				}
			}
		}
	}



}
