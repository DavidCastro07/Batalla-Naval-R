package CampoBatalla;

import java.util.ArrayList;

import Barco.Barco;
import Barcos.BarcoBatalla;
import Barcos.Intercepto;
import Barcos.Patrulla;
import Barcos.Submarino;
import Coordenada.Coordenada;


public class CampoBatalla {

	private final Integer tamanioX;
	private final Integer tamanioY;
	private final ArrayList<Coordenada> tablero;

	public CampoBatalla(Integer tamanioX, Integer tamanioY){
		this.tamanioX = tamanioX;
		this.tamanioY = tamanioY;
		tablero = new ArrayList<Coordenada>();
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
				//boolean encontrado = false;
				for (Coordenada coord : tablero) {
					if (coord.getCoordX() == i && coord.getCoordY() == j) {
						if (coord.getBarco() == null) {
							System.out.print("- "); // Si hay un barco en null, imprimir "-" seria el agua
							break;
						} else if (coord.getBarco() instanceof BarcoBatalla) {
							System.out.print("B "); // Si hay un barco, imprimir "B" seria el agua
							break;
						} else if (coord.getBarco() instanceof Intercepto) {
							System.out.print("I "); // Si hay un Intercepto, imprimir "I" seria el agua
							break;
						} else if (coord.getBarco() instanceof Patrulla) {
							System.out.print("P "); // Si hay un Patrulla, imprimir "P" seria el agua
							break;
						} else if (coord.getBarco() instanceof Submarino) {
							System.out.print("B "); // Si hay un Submarino, imprimir "S" seria el agua
							break;
						} else {
							System.out.print("1 "); // Si hay una coordenada en esta posición, imprimir "1"
							break;
						}
					}
				}
			}
			System.out.println();
		}
	}
	public void agregarBarco(Barco barco){
		if (barco.getDireccion()){//vertical
			if (verificarVertical(barco)){
				for (int i = barco.getCoordenada().getCoordX(); i < barco.getCoordenada().getCoordX() + barco.getTamanio(); i++) {
					for (int j = barco.getCoordenada().getCoordY(); j <= barco.getCoordenada().getCoordY() ; j++) {
						for (Coordenada coor : tablero){
							if (coor.getCoordX().equals(i) && coor.getCoordY().equals(j)){
								coor.setBarco(barco);
							}
						}
					}
				}
			}else {
				System.out.println("No se puede agregar en esta coordenada");
			}
		}else{//horizontal
			if(verificarHorizontal(barco)){
				for (int i = barco.getCoordenada().getCoordX(); i <= barco.getCoordenada().getCoordX(); i++) {
					for (int j = barco.getCoordenada().getCoordY(); j < barco.getCoordenada().getCoordY() + barco.getTamanio() ; j++) {
						for (Coordenada coor : tablero){
							if (coor.getCoordX().equals(i) && coor.getCoordY().equals(j)){
								coor.setBarco(barco);
							}
						}
					}
				}
			}else {
				System.out.println("No se puede agregar en esta coordenada");
			}
		}
	}
	public boolean verificarVertical(Barco barco){
		int finX = barco.getCoordenada().getCoordX() + barco.getTamanio() - 1;
		if (finX >= tamanioX) {
			return false; // El barco excede el límite vertical del tablero
		}
		for (int i = barco.getCoordenada().getCoordX(); i < barco.getCoordenada().getCoordX() + barco.getTamanio(); i++) {
			for (int j = barco.getCoordenada().getCoordY(); j <= barco.getCoordenada().getCoordY() ; j++) {
				for (Coordenada coord: tablero){
					if (coord.getCoordX().equals(i) && coord.getCoordY().equals(j) && coord.getBarco() != null){
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean verificarHorizontal(Barco barco){
		int finY = barco.getCoordenada().getCoordY() + barco.getTamanio() - 1;
		if (finY >= tamanioY) {
			return false; // El barco excede el límite horizontal del tablero
		}
		for (int i = barco.getCoordenada().getCoordX(); i <= barco.getCoordenada().getCoordX(); i++) {
			for (int j = barco.getCoordenada().getCoordY(); j < barco.getCoordenada().getCoordY() + barco.getTamanio() ; j++) {
				for (Coordenada coord : tablero){
					if (coord.getCoordX().equals(i) && coord.getCoordY().equals(j) && coord.getBarco() != null){
						return false;
					}
				}
			}
		}
		return true;
	}
	public void disparar(Integer coordX, Integer coodY){
		for (Coordenada coord: getTablero()){
			if(coord.getCoordX() == coordX && coord.getCoordY() == coodY){
				if (coord.getBarco() == null){
					System.out.println("No le diste a nada");
					mostrarTablero();
				}else {
					System.out.println("Le diste a un barco");
					coord.setBarco(null);
					mostrarTablero();
				}
			}
		}
	}
	public boolean verificarVacio(){
		for (Coordenada coord: tablero){
			if (coord.getBarco() != null){
				return false;
			}
		}
		return true;
	}
	public Integer getTamanioX() {return tamanioX;}
	public Integer getTamanioY(){return tamanioY;}
	public ArrayList<Coordenada> getTablero(){return tablero;}
}
