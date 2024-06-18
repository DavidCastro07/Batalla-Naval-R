package src.Clases;

import java.util.Observable;
import src.Clases.Observer;
import src.Interfaz.Juego;

public class BarcosHundidos implements Observer{
    private int hundidos;
    private int perdidos;
    private Juego juego;

    public void update(int disparos, int barcosHundidos, int BarcosPerdidos) {
        hundidos = barcosHundidos;
        perdidos = BarcosPerdidos;
        ImprimirCantidad( barcosHundidos, BarcosPerdidos);
    }
    public BarcosHundidos(Juego juego) {
        this.juego = juego;
    }

    private void ImprimirCantidad(int hundido, int perdido) {
            this.juego.jBHjugador.setText(String.valueOf(hundido));
            this.juego.jBHMaquina.setText(String.valueOf(perdido));
    }



}