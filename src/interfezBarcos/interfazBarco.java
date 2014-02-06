package interfezBarcos;

import Coordenada.Coordenada;

public interface interfazBarco {
	
	/**
	 * Este metodo nos verficara
	 * si el disparo fue certero.
	 * 
	 * 
	 * @return boolean
	 */
	public boolean verificarDisparo(Coordenada disparo);
	
	/**
	 * Este metodo revisara si el barco se hundio
	 * 
	 * @return boolean
	 */
	
	public boolean verficarHundimiento();
	
}
