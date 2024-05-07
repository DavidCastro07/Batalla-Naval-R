package Barco;

import Coordenada.Coordenada;

public class Barco {
	private boolean direccion;// false: horizontal, true: vertical
	private Coordenada coordenada;
	private Integer vida;
	private Integer tamanio;

	public Barco(Boolean direccion, Coordenada coordenada, Integer tamanio){
		this.direccion = direccion;
		this.coordenada = coordenada;
		this.vida = tamanio;
		this.tamanio = tamanio;
	}

	public Coordenada getCoordenada(){return coordenada;}
	public boolean getDireccion(){return direccion;}
	public Integer getTamanio(){return tamanio;}
}
