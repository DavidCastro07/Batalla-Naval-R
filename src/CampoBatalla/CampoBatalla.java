package CampoBatalla;

import java.util.ArrayList;

import Coordenada.Coordenada;
import interfezBarcos.interfazBarco;

public class CampoBatalla {
	
	private ArrayList<interfazBarco> barcosEnCampo;
	private ArrayList<Coordenada> tirosDados;
	private Coordenada disparo;
	
	
	public CampoBatalla(){
		barcosEnCampo = new ArrayList<interfazBarco>();
		tirosDados = new ArrayList<Coordenada>();
		
	}
	
	public void agregarBarco(interfazBarco barco){
		
		this.barcosEnCampo.add(barco);
		
	}
	
	public void disparar(Coordenada disparo){
		this.disparo = disparo;
		boolean disp = false;
		
		if(this.getTirosDados().size() == 0){
			this.getTirosDados().add(disparo);
			disp = true;
		}else{
			for(int i = 0; i < this.getTirosDados().size(); i++){
				if(getDisparo().equals(this.getTirosDados().get(i))){
					System.out.println("Ya se genero el tiro");
					disp = false;
					break;
				}else{
					System.out.println("Nuevo tiro");
					disp = true;
					this.getTirosDados().add(disparo);
					break;
				}
			}
		}
		
		if(disp){
			for(int i = 0; i < barcosEnCampo.size(); i++){
				this.barcosEnCampo.get(i).verficarHundimiento();
				if(barcosEnCampo.get(i).verificarDisparo(this.getDisparo())){
					System.out.println("Atino");
					break;
				}else{
					System.out.println("No se atino");
				}
			}
			System.out.println("Se lanzo");
		}else{
			System.out.println("No se lanzo el tiro porque ya se habia lanzado");
		}
		
		
	}
	
	public void mostrarBarcos(){
		for(int i = 0; i < barcosEnCampo.size(); i++){
			System.out.println(barcosEnCampo.get(i));
		}
	}

	public ArrayList<interfazBarco> getBarcosEnCampo() {
		return barcosEnCampo;
	}

	public void setBarcosEnCampo(ArrayList<interfazBarco> barcosEnCampo) {
		this.barcosEnCampo = barcosEnCampo;
	}

	public ArrayList<Coordenada> getTirosDados() {
		return tirosDados;
	}

	public void setTirosDados(ArrayList<Coordenada> tirosDados) {
		this.tirosDados = tirosDados;
	}

	public Coordenada getDisparo() {
		return disparo;
	}

	public void setDisparo(Coordenada disparo) {
		this.disparo = disparo;
	}
	
	
	
}
