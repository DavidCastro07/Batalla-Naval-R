package Nivel;

import Barco.Barco;
import Barcos.BarcoBatalla;
import Barcos.Patrulla;
import CampoBatalla.CampoBatalla;
import Coordenada.Coordenada;

import java.util.Random;
import java.util.Scanner;

public class Nivel {
    CampoBatalla campoBatalla;

    public Nivel(CampoBatalla campoBatalla){
        this.campoBatalla = campoBatalla;
    }

    public void jugarNivelUno(){
        Scanner scanner = new Scanner(System.in);
        Integer coordX;
        Integer coordY;
        Integer disparos = 15;

        campoBatalla.generarTablero();
        campoBatalla.mostrarTablero();


        campoBatalla.agregarBarco(generarBarcoBatallaRandom());
        campoBatalla.agregarBarco(generarPatrullaRandom());
        campoBatalla.mostrarTablero();
        System.out.println("Tenes " + disparos + " disparos");
        do {
            System.out.println("Elegir coordenada Fila");
            coordX = scanner.nextInt();
            System.out.println("Elegir coordenada Columna");
            coordY = scanner.nextInt();
            campoBatalla.disparar(coordX, coordY);
            disparos--;
            System.out.println("Te quedan " + disparos + " disparos");
        }while (disparos > 0 && !campoBatalla.verificarVacio());

        if(campoBatalla.verificarVacio()){
            System.out.println("Felicidades, superaste el primer nivel.");
        }
        if(!campoBatalla.verificarVacio() && disparos <= 0){
            System.out.println("Perdiste xd");
        }
    }


    public BarcoBatalla generarBarcoBatallaRandom(){
        boolean direccion = generarDireccionRandom();
        BarcoBatalla barcoBatalla;

        if (direccion){//vertical
            do {
                barcoBatalla = new BarcoBatalla(direccion,generarCoordenadaRandom(campoBatalla.getTamanioX(),
                        campoBatalla.getTamanioY()));
            }while(!campoBatalla.verificarVertical(barcoBatalla));
        }else {
            do {
                barcoBatalla = new BarcoBatalla(direccion,generarCoordenadaRandom(campoBatalla.getTamanioX(),
                        campoBatalla.getTamanioY()));
            }while(!campoBatalla.verificarHorizontal(barcoBatalla));
        }
        return barcoBatalla;
    }
    public Patrulla generarPatrullaRandom(){
        boolean direccion = generarDireccionRandom();
        Patrulla patrulla;

        if (direccion){//vertical
            do {
                patrulla = new Patrulla(direccion,generarCoordenadaRandom(campoBatalla.getTamanioX(),
                        campoBatalla.getTamanioY()));
            }while(!campoBatalla.verificarVertical(patrulla));
        }else {
            do {
                patrulla = new Patrulla(direccion,generarCoordenadaRandom(campoBatalla.getTamanioX(),
                        campoBatalla.getTamanioY()));
            }while(!campoBatalla.verificarHorizontal(patrulla));
        }
        return patrulla;
    }
    public Coordenada generarCoordenadaRandom(Integer coorX, Integer coorY){
        Random random = new Random();
        Coordenada coordenada = new Coordenada(random.nextInt(coorX),random.nextInt(coorY));
        return coordenada;
    }
    public boolean generarDireccionRandom(){
        Random random = new Random();
        Integer numero = random.nextInt(2);
        if (numero == 1){return false;}
        else {return true;}
    }
}
