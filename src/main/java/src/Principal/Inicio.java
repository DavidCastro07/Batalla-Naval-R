package Principal;

import Clases.ControlJuego;
import Clases.Efecto;
import Interfaz.Juego;

public class Inicio {
    
    /*
    *
    *@autor Fernando Huañec H.
    *@mail xfer94x@gmail.com    
    *
    */

    public static void main(String[] args) {
        Juego vista = new Juego();
        Efecto efecto = new Efecto(vista);
        ControlJuego control = new ControlJuego(vista, efecto.BotonBase, efecto.BotonMapa, efecto.Muestra);
        control.IniciarJuego();
        vista.setVisible(true);
    }
}
