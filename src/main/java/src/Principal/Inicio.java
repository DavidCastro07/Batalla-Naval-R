package src.Principal;

import src.Clases.ControlJuego;
import src.Clases.Efecto;
import src.Interfaz.Juego;

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
