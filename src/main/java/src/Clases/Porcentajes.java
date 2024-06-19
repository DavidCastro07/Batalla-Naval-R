package src.Clases;

import src.Interfaz.Juego;
import java.util.Observable;
import src.Clases.Observer;


    public class Porcentajes implements Observer{
        private int porcentaje=0;
        private int hundidos;
        private int dispaross;
        private Juego juego;

        public void update(int disparos, int Hundidos, int Perdidos) {
            hundidos=Hundidos;
            dispaross=disparos;
            ImprimirPorcentaje(dispaross,hundidos);
        }
        public Porcentajes(Juego juego) {
            this.juego = juego;
        }

        private void ImprimirPorcentaje(int disparo, int hundido) {
            if (juego != null && juego.jExito != null) {
                int undido = hundido * 3;
                float tasa = (float) undido / disparo;
                int porcentaje = (int) (tasa * 100);
                this.juego.jExito.setText(String.valueOf(porcentaje));
            } else {
                // Manejo de casos donde juego o jExito es null
                System.out.println("juego or jExito is null");
            }
        }
        }


