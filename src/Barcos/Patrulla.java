package Barcos;

import Barco.Barco;
import Coordenada.Coordenada;

public class Patrulla extends Barco {
	private final Integer TAMANIO;

	public Patrulla(boolean direccion, Coordenada coordenada){
		super(direccion, coordenada,2);
		this.TAMANIO = 2;
	}
}
