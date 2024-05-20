package Clases;

import Interfaz.Juego;

public class Cronometro implements Runnable{
    
    private Thread hiloCronometro;
    private boolean go,live;
    private int segundos;
    private Juego juego;

    public Cronometro(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void run() {
        try {
            while (isLive()) {
                synchronized(this) {
                    while (!isGo())
                        wait();
                }
                Thread.sleep(1000); // original Thread.sleep(1000);
                segundos++;
                actualizarThread();
            }
        } catch (InterruptedException e) {}
    }
    
    public void createThread() {
        hiloCronometro = new Thread(this);
        hiloCronometro.start();
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
            int Thora= segundos/3600;
            int Tminuto =(segundos-Thora*3600)/60;
            int Tsegundo = segundos-Thora*3600-Tminuto*60;
            ImprimirTiempo(Thora,Tminuto,Tsegundo);
        } else {
            segundos = 0;
            this.juego.jTiempo.setText("00 : 00 : 00");
        }
    }
    
    private void ImprimirTiempo(int Thora, int Tminuto, int Tsegundo){
        if(Thora<=9){
            if(Tminuto<=9){
                if(Tsegundo<=9){
                    this.juego.jTiempo.setText("0"+Thora+" : 0"+Tminuto+" : 0"+Tsegundo);
                }else{
                    this.juego.jTiempo.setText("0"+Thora+" : 0"+Tminuto+" : "+Tsegundo);
                }
            }else{
                if(Tsegundo<=9){
                    this.juego.jTiempo.setText("0"+Thora+" : "+Tminuto+" : 0"+Tsegundo);
                }else{
                    this.juego.jTiempo.setText("0"+Thora+" : "+Tminuto+" : "+Tsegundo);
                }
            }
        }else{
            if(Tminuto<=9){
                if(Tsegundo<=9){
                    this.juego.jTiempo.setText(Thora+" : 0"+Tminuto+" : 0"+Tsegundo);
                }else{
                    this.juego.jTiempo.setText(Thora+" : 0"+Tminuto+" : "+Tsegundo);
                }
            }else{
                if(Tsegundo<=9){
                    this.juego.jTiempo.setText(Thora+" : "+Tminuto+" : 0"+Tsegundo);
                }else{
                    this.juego.jTiempo.setText(Thora+" : "+Tminuto+" : "+Tsegundo);
                }
            }
            
        }
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
    
    public int getSegundos() {
        return segundos;
    }
    
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
}
