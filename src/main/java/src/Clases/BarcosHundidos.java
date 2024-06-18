package src.Clases;

import java.util.Observable;
import src.Clases.Observer;
import src.Interfaz.Juego;

public class BarcosHundidos implements Observer{
    private int hundidos;
    private int perdidos;
    private int disparo;

    public void update(int disparos, int barcosHundidos, int BarcosPerdidos) {
        hundidos = barcosHundidos;
        perdidos = BarcosPerdidos;
        disparo=disparos+1;
        ImprimirCantidad(disparos, barcosHundidos, BarcosPerdidos);

    }

    private Juego juego;

    public BarcosHundidos(Juego juego) {
        this.juego = juego;
    }

    private void ImprimirCantidad(int disparo,int hundido, int perdido) {
 int porcentaje=Math.round((float) disparo /hundido);
 porcentaje=porcentaje*100;
            this.juego.jBHjugador.setText(String.valueOf(hundido));
            this.juego.jBHMaquina.setText(String.valueOf(perdido));
        this.juego.jExito.setText(String.valueOf(porcentaje));


    }



}