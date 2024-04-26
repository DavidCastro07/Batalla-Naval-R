package Barcos;

import java.util.Arrays;
import java.util.Random;

import Barco.Barco;
import Coordenada.Coordenada;

public class Submarino extends Barco {
	private final Integer TAMANIO;

	public Submarino(boolean direccion, Coordenada coordenada){
		super(direccion, coordenada,3);
		this.TAMANIO = 3;
	}
}
