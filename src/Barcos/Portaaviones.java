package Barcos;

import java.util.Arrays;
import java.util.Random;

import Barco.Barco;
import Coordenada.Coordenada;

public class Portaaviones extends Barco {
	private final Integer TAMANIO;

	public Portaaviones(boolean direccion, Coordenada coordenada){
		super(direccion, coordenada,6);
		this.TAMANIO = 6;
	}
}
