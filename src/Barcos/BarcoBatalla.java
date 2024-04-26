package Barcos;

import java.util.Arrays;
import java.util.Random;

import Barco.Barco;
import Coordenada.Coordenada;


public class BarcoBatalla extends Barco {
	
	private final Integer TAMANIO;

	public BarcoBatalla(boolean direccion, Coordenada coordenada){
		super(direccion, coordenada,5);
		this.TAMANIO = 5;
	}

}
