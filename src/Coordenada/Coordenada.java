package Coordenada;

import Barco.Barco;

public class Coordenada {
	private Integer coordX;
	private Integer coordY;
	private Barco barco = null;

	public Coordenada(Integer coordX, Integer coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Integer getCoordX() {
		return coordX;
	}
	public void setCoordX(Integer coordX) {
		this.coordX = coordX;
	}
	public Integer getCoordY() {
		return coordY;
	}
	public void setCoordY(Integer coordY) {
		this.coordY = coordY;
	}
	public Barco getBarco(){return barco;}
	public void setBarco(Barco barco){this.barco = barco;}

	
}
