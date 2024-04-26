import Barcos.BarcoBatalla;
import CampoBatalla.CampoBatalla;
import Coordenada.Coordenada;


public class main {
	public static void main(String[] args){
		CampoBatalla campo = new CampoBatalla(10,10);
		campo.generarTablero();
		campo.mostrarTablero();

		Coordenada coordenadaBB1 = new Coordenada(0,0);
		BarcoBatalla barcoBatalla1 = new BarcoBatalla(true, coordenadaBB1);

		campo.agregarBarco(barcoBatalla1);
		campo.mostrarTablero();

		Coordenada coordenadaBB2 = new Coordenada(0,1);
		BarcoBatalla barcoBatalla2 = new BarcoBatalla(false, coordenadaBB2);

		campo.agregarBarco(barcoBatalla2);
		campo.mostrarTablero();
		/*Scanner t = new Scanner(System.in);
		int corX = 0;
		int corY = 0;
		Coordenada disparo;
		CampoBatalla campo = new CampoBatalla();
		
		//Barco 1
		BarcoBatalla bb = new BarcoBatalla(true);
		//Barco 2
		Intercepto inter = new Intercepto(false);
		//Barco 3
		Patrulla pat = new Patrulla(false);
		//Barco 4
		Portaaviones porta = new Portaaviones(true);
		//Barco 5
		Submarino sub = new Submarino(true);
		
		//Agregar barcos
		campo.agregarBarco(bb);
		campo.agregarBarco(inter);
		campo.agregarBarco(pat);
		campo.agregarBarco(porta);
		campo.agregarBarco(sub);
		
		//Imprimir barcos
		campo.mostrarBarcos();
		
		while(!(bb.verficarHundimiento() && inter.verficarHundimiento() && pat.verficarHundimiento() && porta.verficarHundimiento() && sub.verficarHundimiento())){
			System.out.println("Dame coordenada X");
			corX = t.nextInt();
			System.out.println("Dame coordenada Y");
			corY = t.nextInt();
			disparo = new Coordenada(corX,corY);
			System.out.println("Tu disparo fue en: " + disparo);
			
			campo.disparar(disparo);
			
			
		}
	*/
		
	}
}
