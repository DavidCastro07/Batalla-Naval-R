import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import CampoBatalla.CampoBatalla;
import Nivel.Nivel;
import Barcos.BarcoBatalla;
import Barcos.Patrulla;

class GenerarFinDePartidaTest {

	@Test

    public static void main(String[] args) {
		
        Integer cordX = 5, cordY = 5;
		
		System.out.println("Seleccionaste la opción 1");
		CampoBatalla campoBatalla = new CampoBatalla(5,5);
		Nivel nivelUno = new Nivel(campoBatalla);
		BarcoBatalla barcobatalla = nivelUno.generarBarcoBatallaRandom();
		Patrulla patrulla = nivelUno.generarPatrullaRandom();		
		campoBatalla.generarTablero();
        campoBatalla.agregarBarco(barcobatalla);
        campoBatalla.agregarBarco(patrulla);
      
		
        for (int i = 0; i < cordX; i++) {
            for (int j = 0; j < cordY; j++) {
            	
            	if(campoBatalla.verificarVacio() == false) {
            		
            	   campoBatalla.disparar(i, j);
            	   
            	}
            }

            }
        	
        assertTrue(campoBatalla.verificarVacio(), "Fin de Partida");

	}

}
