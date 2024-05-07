package Barcos;

import Barco.Barco;
import Coordenada.Coordenada;

public class Intercepto extends Barco {
	private final Integer TAMANIO;

	public Intercepto(boolean direccion, Coordenada coordenada){
		super(direccion, coordenada,1);
		this.TAMANIO = 1;
	}
}