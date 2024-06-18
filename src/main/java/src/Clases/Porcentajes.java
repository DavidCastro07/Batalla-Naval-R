package src.Clases;

import src.Interfaz.Juego;
import java.util.Observable;
import src.Clases.Observer;


    public class Porcentajes implements Observer{
        private int porcentaje;

        private Juego juego;

        public void update(int disparos, int Hundidos, int Perdidos) {
            ImprimirPorcentaje( disparos,Hundidos);
        }
        public Porcentajes(Juego juego) {
            this.juego = juego;
        }

        private void ImprimirPorcentaje(int disparo, int hundido) {
            float tasa = (float) hundido /disparo;
            porcentaje= (int) tasa;
            this.juego.jExito.setText(String.valueOf(porcentaje));
        }
        }


