package Principal;

import Clases.ControlJuego;
import Clases.Efecto;
import Interfaz.Juego;

public class Inicio {

    public static void main(String[] args) {
        Juego vista = Juego.getInstance();
        Efecto efecto = Efecto.getInstance(vista);
        ControlJuego control = new ControlJuego(vista, efecto.BotonBase, efecto.BotonMapa, efecto.Muestra);
        control.IniciarJuego();
        vista.setVisible(true);
        //r
    }
}
