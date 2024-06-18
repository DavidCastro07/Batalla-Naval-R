package src.Clases;

import src.Interfaz.Juego;
import java.awt.Color;
import javax.swing.JButton;

public class BarcosEnemigos {

    Juego juego;
    JButton BotonMapa[];
    JButton BotonBase[];
    boolean BarcosEnemigos[];
    Color pred;
    JButton MemoricBoton[] = new JButton[30];
    JButton MemoricBase[];
    JButton ALREDEDOR[];
    boolean DETENER = false;
    JButton barco[];//120
    public Cronometro cronometro;
    public BarcosHundidos barcoshundidos;
    ControlMovimiento controlmovimiento;

    public BarcosEnemigos(Juego juego, JButton BotonMapa[], JButton BotonBase[], JButton MemoricBase[],ControlMovimiento controlmovimiento) {
        this.juego = juego;
        this.BotonMapa = BotonMapa;
        this.BotonBase = BotonBase;
        this.MemoricBase = MemoricBase;
        this.controlmovimiento=controlmovimiento;
    }

    private void BarcosEnemigos() {
        BarcosEnemigos = new boolean[10];
        ALREDEDOR = new JButton[120];
        for (int i = 0; i < 10; i++) {
            BarcosEnemigos[i] = false;
        }
    }

    public void Iniciar() {
        BarcosEnemigos();
        pred = juego.jEmpezar.getBackground();
        ColocarBarco();
    }

    private void ColocarBarco() {
        while (true) {
            int numero = aleatorio();
            if (!BarcosEnemigos[0]) {
                PosicionarBarco("Barco1", numero);
                memorizar(FinalBarco(), "Barco1", 0);
            } else if (!BarcosEnemigos[1]) {
                PosicionarBarco("Barco2", numero);
                memorizar(FinalBarco(), "Barco2", 1);
            } else if (!BarcosEnemigos[2]) {
                PosicionarBarco("Barco3", numero);
                memorizar(FinalBarco(), "Barco3", 2);
            } else if (!BarcosEnemigos[3]) {
                PosicionarBarco("Barco4", numero);
                memorizar(FinalBarco(), "Barco4", 3);
            } else if (!BarcosEnemigos[4]) {
                PosicionarBarco("Barco5", numero);
                memorizar(FinalBarco(), "Barco5", 4);
            } else if (!BarcosEnemigos[5]) {
                PosicionarBarco("Barco6", numero);
                memorizar(FinalBarco(), "Barco6", 5);
            } else if (!BarcosEnemigos[6]) {
                PosicionarBarco("Barco7", numero);
                memorizar(FinalBarco(), "Barco7", 6);
            } else if (!BarcosEnemigos[7]) {
                PosicionarBarco("Barco8", numero);
                memorizar(FinalBarco(), "Barco8", 7);
            } else if (!BarcosEnemigos[8]) {
                PosicionarBarco("Barco9", numero);
                memorizar(FinalBarco(), "Barco9", 8);
            } else if (!BarcosEnemigos[9]) {
                PosicionarBarco("Barco10", numero);
                memorizar(FinalBarco(), "Barco10", 9);
            } else if (DETENER) {
                Jugar jugar = new Jugar(MemoricBoton, BotonMapa, BotonBase, juego, MemoricBase, this);
                cronometro = new Cronometro(juego);
                cronometro.createThread();
                cronometro.setLive(true);
                cronometro.setGo(true);
                barcoshundidos= new BarcosHundidos(juego);
                jugar.addObserver(barcoshundidos);
                jugar.Iniciar();
                break;
            }
        }
    }

    private boolean FinalBarco() {
        boolean OK = false;
        JButton tem[] = getBarco();
        for (int i = 0; i < tem.length; i++) {
            for (int j = 0; j < MemoricBoton.length; j++) {
                if (MemoricBoton[j] == tem[i]) {
                    OK = true;
                    break;
                }
            }
        }

        return OK;
    }

    private void MemorizaAlrededor(String cmd, JButton tem[]) {
        switch (cmd) {
            case "Barco1":
                ALREDEDOR[0] = tem[0];
                break;
            default:
                break;
        }
    }

    private void memorizar(boolean OK, String cmd, int n) {
        if (!OK) {
            JButton tembot[] = barco;
            switch (cmd) {
                case "Barco1":
                    MemorizaAlrededor(cmd, tembot);
                    for (int i = 0; i < 5; i++) {
                        MemoricBoton[i] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.RED);
                    break;
                case "Barco2":
                    for (int i = 0; i < 4; i++) {
                        MemoricBoton[i + 5] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.BLUE);
                    break;
                case "Barco3":
                    for (int i = 0; i < 3; i++) {
                        MemoricBoton[i + 9] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.YELLOW);
                    break;
                case "Barco4":
                    for (int i = 0; i < 2; i++) {
                        MemoricBoton[i + 12] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.GREEN);
                    break;
                case "Barco5":
                    for (int i = 0; i < 5; i++) {
                        MemoricBoton[i + 14] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.RED);
                    break;
                case "Barco6":
                    for (int i = 0; i < 4; i++) {
                        MemoricBoton[i + 19] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.BLUE);
                    break;
                case "Barco7":
                    for (int i = 0; i < 3; i++) {
                        MemoricBoton[i + 23] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.YELLOW);
                    break;
                case "Barco8":
                    for (int i = 0; i < 2; i++) {
                        MemoricBoton[i + 26] = tembot[i];
                        BarcosEnemigos[n] = true;
                    }
                    pintar(tembot, Color.GREEN);
                    break;
                case "Barco9":
                    MemoricBoton[28] = tembot[0];
                    BarcosEnemigos[n] = true;
                    pintar(tembot, Color.BLACK);
                    break;
                case "Barco10":
                    MemoricBoton[29] = tembot[0];
                    BarcosEnemigos[n] = true;
                    pintar(tembot, Color.BLACK);
                    DETENER = true;
                    break;
                default:
                    break;
            }
        }
    }

    private void PosicionarBarco(String cmd, int posicion) {// →←
        for (int i = 0; i < 15; i++) {
            switch (cmd) {
                case "Barco1":
                    if (posicion >= (i * 15) + 10 && posicion <= (i * 15) + 14) {
                        JButton boton[] = {BotonMapa[(i * 15) + 10], BotonMapa[((i * 15) + 10) + 1], BotonMapa[((i * 15) + 10) + 2], BotonMapa[((i * 15) + 10) + 3], BotonMapa[((i * 15) + 10) + 4]};
                        setBarco(boton);
                    } else if (posicion >= (i * 15) && posicion <= (i * 15) + 9) {
                        JButton boton[] = {BotonMapa[posicion], BotonMapa[posicion + 1], BotonMapa[posicion + 2], BotonMapa[posicion + 3], BotonMapa[posicion + 4]};
                        setBarco(boton);
                    }
                    break;
                case "Barco2":
                    if (posicion >= (11 + (i * 15)) && posicion <= (14 + (i * 15))) {
                        JButton boton[] = {BotonMapa[(i * 15) + 11], BotonMapa[((i * 15) + 11) + 1], BotonMapa[((i * 15) + 11) + 2], BotonMapa[((i * 15) + 11) + 3]};
                        setBarco(boton);
                    } else if (posicion >= (i * 15) && posicion <= 10 + (i * 15)) {
                        JButton boton[] = {BotonMapa[posicion], BotonMapa[posicion + 1], BotonMapa[posicion + 2], BotonMapa[posicion + 3]};
                        setBarco(boton);
                    }
                    break;
                case "Barco3":
                    if (posicion >= (12 + (i * 15)) && posicion <= (14 + (i * 15))) {
                        JButton boton[] = {BotonMapa[(i * 15) + 12], BotonMapa[((i * 15) + 12) + 1], BotonMapa[((i * 15) + 12) + 2]};
                        setBarco(boton);
                    } else if (posicion >= (i * 15) && posicion <= 11 + (i * 15)) {
                        JButton boton[] = {BotonMapa[posicion], BotonMapa[posicion + 1], BotonMapa[posicion + 2]};
                        setBarco(boton);
                    }
                    break;
                case "Barco4":
                    if (posicion >= (13 + (i * 15)) && posicion <= (14 + (i * 15))) {
                        JButton boton[] = {BotonMapa[(i * 15) + 13], BotonMapa[((i * 15) + 13) + 1]};
                        setBarco(boton);
                    } else if (posicion >= (i * 15) && posicion <= 12 + (i * 15)) {
                        JButton boton[] = {BotonMapa[posicion], BotonMapa[posicion + 1]};
                        setBarco(boton);
                    }
                    break;
                case "Barco5":
                    if (posicion == (150 + i) || posicion == (165 + i) || posicion == (180 + i) || posicion == (195 + i) || posicion == (210 + i)) {
                        JButton boton[] = {BotonMapa[(150 + i)], BotonMapa[((150 + i) + 15)], BotonMapa[((150 + i) + 30)], BotonMapa[((150 + i) + 45)], BotonMapa[((150 + i) + 60)]};
                        setBarco(boton);
                    } else if (posicion <= 149) {
                        JButton boton[] = {BotonMapa[(posicion)], BotonMapa[((posicion) + 15)], BotonMapa[((posicion) + 30)], BotonMapa[((posicion) + 45)], BotonMapa[((posicion) + 60)]};
                        setBarco(boton);
                    }
                    break;
                case "Barco6":
                    if (posicion == (165 + i) || posicion == (180 + i) || posicion == (195 + i) || posicion == (210 + i)) {
                        JButton boton[] = {BotonMapa[(165 + i)], BotonMapa[((165 + i) + 15)], BotonMapa[((165 + i) + 30)], BotonMapa[((165 + i) + 45)]};
                        setBarco(boton);
                    } else if (posicion <= 164) {
                        JButton boton[] = {BotonMapa[(posicion)], BotonMapa[(posicion + 15)], BotonMapa[(posicion + 30)], BotonMapa[(posicion + 45)]};
                        setBarco(boton);
                    }
                    break;
                case "Barco7":
                    if (posicion == (180 + i) || posicion == (195 + i) || posicion == (210 + i)) {
                        JButton boton[] = {BotonMapa[(180 + i)], BotonMapa[((180 + i) + 15)], BotonMapa[((180 + i) + 30)]};
                        setBarco(boton);
                    } else if (posicion <= 179) {
                        JButton boton[] = {BotonMapa[(posicion)], BotonMapa[(posicion + 15)], BotonMapa[(posicion + 30)]};
                        setBarco(boton);
                    }
                    break;
                case "Barco8":
                    if (posicion == (195 + i) || posicion == (210 + i)) {
                        JButton boton[] = {BotonMapa[(195 + i)], BotonMapa[((195 + i) + 15)]};
                        setBarco(boton);
                    } else if (posicion <= 194) {
                        JButton boton[] = {BotonMapa[(posicion)], BotonMapa[(posicion + 15)]};
                        setBarco(boton);
                    }
                    break;
                case "Barco9":
                    JButton boton1[] = {BotonMapa[posicion]};
                    setBarco(boton1);
                    break;
                case "Barco10":
                    JButton boton2[] = {BotonMapa[posicion]};
                    setBarco(boton2);
                    break;
                default:
                    break;
            }
        }
    }

    private void setBarco(JButton boton[]) {
        barco = boton;
    }

    private JButton[] getBarco() {
        return barco;
    }

    private void pintar(JButton boton[], Color color) {
        for (int i = 0; i < boton.length; i++) {
            boton[i].setBackground(pred);
        }
    }

    private int aleatorio() {
        int numero = (int) (Math.random() * 225);
        return numero;
    }
}