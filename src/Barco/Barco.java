package Barco;

import Coordenada.Coordenada;

import java.util.ArrayList;
import java.util.Random;

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

	/*
	public void generarBarco(){
		Random r= new Random();

		Integer pos = r.nextInt(10);
		//Integer auxY = r.nextInt(10);
		while(!(pos + TAMANIO < 10)){
			pos = r.nextInt(10);
		}
		//Horizontal
		if(this.direccion){

			for(int i = pos, j = 0; i < pos+TAMANIO; i++,j++ ){
				coordenadas[j] = new Coordenada(i,pos);
			}
		}else{
			for(int i = pos,j = 0; i < pos+TAMANIO; i++,j++ ){
				coordenadas[j] = new Coordenada(pos,i);
			}
		}
	}
	*/

	public Coordenada getCoordenada(){return coordenada;}
	public boolean getDireccion(){return direccion;}
	public Integer getTamanio(){return tamanio;}
}
