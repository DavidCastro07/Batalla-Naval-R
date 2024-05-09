package Coordenada;

import java.util.Objects;
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

	@Override// las coordenadas se compararán correctamente cuando uses el método contains() en el ArrayList tablero
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coordenada that = (Coordenada) o;
		return coordX.equals(that.coordX) && coordY.equals(that.coordY);
	}
	@Override// Dos objetos que sean iguales según el método equals() deben tener el mismo código hash
	public int hashCode() {
		return Objects.hash(coordX, coordY);
	}
}
