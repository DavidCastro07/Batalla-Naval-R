import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Coordenada.Coordenada;
import org.junit.jupiter.api.Test;
import CampoBatalla.CampoBatalla;

import java.util.ArrayList;

public class GenerarCampoBatallaTest {
    @Test
    public static void main(String[] args) {
        int tamX = 3;
        int tamY = 3;
        CampoBatalla campoBatalla = new CampoBatalla(tamX,tamY);

        campoBatalla.generarTablero();
        ArrayList<Coordenada> tablero = campoBatalla.getTablero();
        assertEquals(tamX * tamY,tablero.size());//Verifica el tamanio del tablero
        for (int i = 0; i < tamX; i++) {
            for (int j = 0; j < tamY; j++) {
                assertTrue(tablero.contains(new Coordenada(i, j)), "La coordenada (" + i + ", " + j + ") no está presente en el tablero");
            }
        }
    }
}
