package src.Clases;

import java.util.Observable;
import src.Clases.Observer;
import src.Interfaz.Juego;

public class BarcosHundidos implements Observer,Runnable {
    public int hundidos;
    public int perdidos;
    public int disparo;

    public void update(int disparos, int barcosHundidos, int BarcosPerdidos) {
        hundidos = barcosHundidos;
        perdidos = BarcosPerdidos;
        disparo=disparos;

    }

    private Thread hiloBarccosHundidos;
    private boolean go, live;
    private Juego juego;

    public BarcosHundidos(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void run() {
        try {
            while (isLive()) {
                synchronized (this) {
                    while (!isGo())
                        wait();
                }
                Thread.sleep(1000); // original Thread.sleep(1000);
                actualizarThread();
            }
        } catch (InterruptedException e) {
        }
    }

    public void createThread() {
        hiloBarccosHundidos = new Thread(this);
        hiloBarccosHundidos.start();
    }

    public void suspenderThread() {
        setGo(false);
    }

    public synchronized void continuarThread() {
        setGo(true);
        notify();
    }

    private void actualizarThread() {
        if (isLive()) {
            ImprimirCantidad(disparo,hundidos, perdidos);
        } else {
            this.juego.jBHjugador.setText("00");
            this.juego.jBHMaquina.setText("00");
        }
    }

    private void ImprimirCantidad(int disparo,int hundido, int perdido) {

            this.juego.jBHjugador.setText(String.valueOf(hundido));
            this.juego.jBHMaquina.setText(String.valueOf(perdido));
        this.juego.jExito.setText(String.valueOf(disparo));


    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setGo(boolean go) {
        this.go = go;
    }

    public boolean isLive() {
        return live;
    }

    public boolean isGo() {
        return go;
    }


}