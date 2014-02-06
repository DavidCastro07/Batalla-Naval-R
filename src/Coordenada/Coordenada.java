package Coordenada;

public class Coordenada {
	private Integer coordX;
	private Integer coordY;
	
	/**
	 * Metodo que recibe 2 parametros, estos recibiran como argumentos "x" y "y" de una c
	 * coordenada
	 * @param coordX
	 * @param coordY
	 */
	
	public Coordenada(Integer coordX, Integer coordY) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	/**
	 * Sobrecarga del metodo equals, el cual recibe un objeto
	 * El metodo nos ayudara a comparar si las coordenadas son iguales
	 * @param coordenada
	 */
	public boolean equals(Object coordenada){
		if( (coordenada instanceof Coordenada) && ( ((Coordenada) coordenada).getCoordX() == this.coordX  &&  ((Coordenada) coordenada).getCoordY() == this.coordY) ){
			return true;
		}else{
			return false;
		}
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


	@Override
	public String toString() {
		return "Coordenada [coordX=" + coordX + ", coordY=" + coordY + "]";
	}
	
	
	
	
}
