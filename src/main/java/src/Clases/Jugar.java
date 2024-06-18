package src.Clases;

import src.Interfaz.Juego;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import src.Clases.Observer;

public class Jugar {

    JButton MemoricBoton[];
    JButton MemoricBase[];
    JButton BotonMapa[];
    JButton BotonBase[];
    JButton cptBarco1[], cptBarco2[], cptBarco3[], cptBarco4[], cptBarco5[], cptBarco6[], cptBarco7[], cptBarco8[], cptBarco9[], cptBarco10[];
    JButton miBarco1[], miBarco2[], miBarco3[], miBarco4[], miBarco5[], miBarco6[], miBarco7[], miBarco8[], miBarco9[], miBarco10[];
    boolean computerbarcoundido[];
    boolean mibarcoundido[];
    boolean Terminar = false;
    boolean MiTurno = true;
    Juego juego;
    BarcosEnemigos clase;
    JButton MiTiro[] = new JButton[225];
    JButton ComputadoraTiro[] = new JButton[225];
    int t1 = 0, t2 = 0, time = 0,perdidos =0,hundidos=0 ;
    int datocolor[][];
    String tempc[];
    String controles[];
    src.Clases.Archivo archivo;
    boolean actualizar = false;
    Timer objTimer;
    String Nivel;
    JButton NivelEscogido[];
    int TiroRecorrido = 0;
    private List<Observer> observers=new ArrayList<>();

    public Jugar(JButton MemoricBoton[], JButton BotonMapa[], JButton BotonBase[], Juego juego, JButton MemoricBase[], BarcosEnemigos clase) {
        this.MemoricBoton = MemoricBoton;
        this.MemoricBase = MemoricBase;
        this.clase = clase;
        this.BotonMapa = BotonMapa;
        this.BotonBase = BotonBase;
        this.juego = juego;
    }

    public void Iniciar() {
        Nivel();
        DividirBarco();
        for (int i = 0; i < 225; i++) {
            BotonMapa[i].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BotonMapaActionPerformed(e);
                }
            });
        }
    }
    public void addObserver(Observer observer){observers.add(observer);}
    public void removeObserver(Observer observer){observers.remove(observer);}
    public void notifyObservers(){
        for(Observer observer:observers){
            observer.update(TiroRecorrido+1,hundidos,perdidos);
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" IDENTIFICAR BOTON POR MEDIO DE LA POSICION ">
    private int IdentificarBoton(int x, int y) {
        int numero = 0;
        for (int i = 0; i < 15; i++) {
            if (x >= 10 && y >= (i * 25) + 24 && x < 35 && y < (i * 25) + 49) { // izquierda, arriba, derecha, abajo
                numero = (i * 15);
            } else if (x >= 35 && y >= (i * 25) + 24 && x < 60 && y < (i * 25) + 49) {
                numero = (i * 15) + 1;
            } else if (x >= 60 && y >= (i * 25) + 24 && x < 85 && y < (i * 25) + 49) {
                numero = (i * 15) + 2;
            } else if (x >= 85 && y >= (i * 25) + 24 && x < 110 && y < (i * 25) + 49) {
                numero = (i * 15) + 3;
            } else if (x >= 110 && y >= (i * 25) + 24 && x < 135 && y < (i * 25) + 49) {
                numero = (i * 15) + 4;
            } else if (x >= 135 && y >= (i * 25) + 24 && x < 160 && y < (i * 25) + 49) {
                numero = (i * 15) + 5;
            } else if (x >= 160 && y >= (i * 25) + 24 && x < 185 && y < (i * 25) + 49) {
                numero = (i * 15) + 6;
            } else if (x >= 185 && y >= (i * 25) + 24 && x < 210 && y < (i * 25) + 494) {
                numero = (i * 15) + 7;
            } else if (x >= 210 && y >= (i * 25) + 24 && x < 235 && y < (i * 25) + 49) {
                numero = (i * 15) + 8;
            } else if (x >= 235 && y >= (i * 25) + 24 && x < 260 && y < (i * 25) + 49) {
                numero = (i * 15) + 9;
            } else if (x >= 260 && y >= (i * 25) + 24 && x < 285 && y < (i * 25) + 49) {
                numero = (i * 15) + 10;
            } else if (x >= 285 && y >= (i * 25) + 24 && x < 310 && y < (i * 25) + 49) {
                numero = (i * 15) + 11;
            } else if (x >= 310 && y >= (i * 25) + 24 && x < 335 && y < (i * 25) + 49) {
                numero = (i * 15) + 12;
            } else if (x >= 335 && y >= (i * 25) + 24 && x < 360 && y < (i * 25) + 49) {
                numero = (i * 15) + 13;
            } else if (x >= 360 && y >= (i * 25) + 24 && x < 385 && y < (i * 25) + 49) {
                numero = (i * 15) + 14;
            }
        }
        return numero;
    }
    //</editor-fold>

    private void BotonMapaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (!Terminar) {
                int x = juego.jPanel3.getMousePosition().getLocation().x;
                int y = juego.jPanel3.getMousePosition().getLocation().y;
                if (MiTurno) {
                    VerificarBarcoUndido(x, y);
                    ComputerBarcoUndido();
                    notifyObservers();
                }
            }
        } catch (NullPointerException e) {
        }
    }

    private void HayGanador() {
        if (computerbarcoundido[0] && computerbarcoundido[1] && computerbarcoundido[2] && computerbarcoundido[3] && computerbarcoundido[4] && computerbarcoundido[5] && computerbarcoundido[6] && computerbarcoundido[7] && computerbarcoundido[8] && computerbarcoundido[9]) {
            Terminar = true;
            //DETENEMOS EL CRONOMETRO            
            String tiempo = juego.jTiempo.getText();
            this.juego.jTiempo.setText(tiempo);
            this.clase.cronometro.setLive(false);
            this.clase.cronometro.setGo(false);
            this.clase.cronometro.setSegundos(0);
            archivo.concatenar("archivos/Clasificacion.txt", getTitulo() + "%%%%" + tiempo + "%%%%" + Nivel + "%%%%");
            JOptionPane.showMessageDialog(null, "!Felicidades¡\n Usted Gano \n El Tiempo fue de - " + tiempo, "Mensaje de Victoria", JOptionPane.INFORMATION_MESSAGE);
        } else if (mibarcoundido[0] && mibarcoundido[1] && mibarcoundido[2] && mibarcoundido[3] && mibarcoundido[4] && mibarcoundido[5] && mibarcoundido[6] && mibarcoundido[7] && mibarcoundido[8] && mibarcoundido[9]) {
            Terminar = true;
            //DETENEMOS EL CRONOMETRO
            String tiempo = juego.jTiempo.getText();
            this.juego.jTiempo.setText(tiempo);
            this.clase.cronometro.setLive(false);
            this.clase.cronometro.setGo(false);
            this.clase.cronometro.setSegundos(0);
            archivo.concatenar("archivos/Clasificacion.txt", "Computadora" + "%%%%" + tiempo + "%%%%" + Nivel + "%%%%");
            JOptionPane.showMessageDialog(null, "Usted Perdio! \n El Ganador es la Computadora. \n El Tiempo fue de - " + tiempo, "Mensaje del Ganador", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void TiroComputadora() {
        while (true) {
            if (Nivel.equalsIgnoreCase("Medio")) {
                NivelEscogido[TiroRecorrido].setBackground(new Color(datocolor[5][3], datocolor[5][2], datocolor[5][1], datocolor[5][0]));
                NivelEscogido[TiroRecorrido].setName("undido");
                MostrarSiMeDio(NivelEscogido[TiroRecorrido]);
                MiTurno = true;
                TiroRecorrido++;
                break;
            } else if (Nivel.equalsIgnoreCase("Dificil")) {
                NivelEscogido[TiroRecorrido].setBackground(new Color(datocolor[5][3], datocolor[5][2], datocolor[5][1], datocolor[5][0]));
                NivelEscogido[TiroRecorrido].setName("undido");
                MostrarSiMeDio(NivelEscogido[TiroRecorrido]);
                MiTurno = true;
                TiroRecorrido++;
                break;
            } else if (Nivel.equalsIgnoreCase("Facil")) {
                int fuego = aleatorio();
                JButton fire = BotonBase[fuego];
                if (!TiroRepetidoBase(fire)) {
                    ComputadoraTiro[t2] = fire;
                    BotonBase[fuego].setBackground(new Color(datocolor[5][3], datocolor[5][2], datocolor[5][1], datocolor[5][0]));
                    BotonBase[fuego].setName("undido");
                    t2++;
                    MostrarSiMeDio(ComputadoraTiro[(t2 - 1)]);
                    MiTurno = true;
                    break;
                }
            }
        }
        MiBarcoUndido();
        HayGanador();

    }

    private void MostrarSiMeDio(JButton tiro) {
        if (miBarco1[0] == tiro || miBarco1[1] == tiro || miBarco1[2] == tiro || miBarco1[3] == tiro || miBarco1[4] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco2[0] == tiro || miBarco2[1] == tiro || miBarco2[2] == tiro || miBarco2[3] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco3[0] == tiro || miBarco3[1] == tiro || miBarco3[2] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco4[0] == tiro || miBarco4[1] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco5[0] == tiro || miBarco5[1] == tiro || miBarco5[2] == tiro || miBarco5[3] == tiro || miBarco5[4] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco6[0] == tiro || miBarco6[1] == tiro || miBarco6[2] == tiro || miBarco6[3] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco7[0] == tiro || miBarco7[1] == tiro || miBarco7[2] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco8[0] == tiro || miBarco8[1] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco9[0] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
        if (miBarco10[0] == tiro) {
            tiro.setBackground(new Color(datocolor[2][3], datocolor[2][2], datocolor[2][1], datocolor[2][0]));
        }
    }

    private void MostrarsileDi(JButton tiro) {
        if (cptBarco1[0] == tiro || cptBarco1[1] == tiro || cptBarco1[2] == tiro || cptBarco1[3] == tiro || cptBarco1[4] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco2[0] == tiro || cptBarco2[1] == tiro || cptBarco2[2] == tiro || cptBarco2[3] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco3[0] == tiro || cptBarco3[1] == tiro || cptBarco3[2] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco4[0] == tiro || cptBarco4[1] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco5[0] == tiro || cptBarco5[1] == tiro || cptBarco5[2] == tiro || cptBarco5[3] == tiro || cptBarco5[4] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco6[0] == tiro || cptBarco6[1] == tiro || cptBarco6[2] == tiro || cptBarco6[3] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco7[0] == tiro || cptBarco7[1] == tiro || cptBarco7[2] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco8[0] == tiro || cptBarco8[1] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco9[0] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
        if (cptBarco10[0] == tiro) {
            tiro.setBackground(new Color(datocolor[3][3], datocolor[3][2], datocolor[3][1], datocolor[3][0]));
        }
    }

    private void MiBarcoUndido() {
        if (!mibarcoundido[0]) {
            if (miBarco1[0].getName().equals("undido") && miBarco1[1].getName().equals("undido") && miBarco1[2].getName().equals("undido") && miBarco1[3].getName().equals("undido") && miBarco1[4].getName().equals("undido")) {
                miBarco1[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco1[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco1[2].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco1[3].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco1[4].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[0] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[1]) {
            if (miBarco2[0].getName().equals("undido") && miBarco2[1].getName().equals("undido") && miBarco2[2].getName().equals("undido") && miBarco2[3].getName().equals("undido")) {
                miBarco2[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco2[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco2[2].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco2[3].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[1] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[2]) {
            if (miBarco3[0].getName().equals("undido") && miBarco3[1].getName().equals("undido") && miBarco3[2].getName().equals("undido")) {
                miBarco3[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco3[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco3[2].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[2] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[3]) {
            if (miBarco4[0].getName().equals("undido") && miBarco4[1].getName().equals("undido")) {
                miBarco4[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco4[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[3] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[4]) {
            if (miBarco5[0].getName().equals("undido") && miBarco5[1].getName().equals("undido") && miBarco5[2].getName().equals("undido") && miBarco5[3].getName().equals("undido") && miBarco5[4].getName().equals("undido")) {
                miBarco5[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco5[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco5[2].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco5[3].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco5[4].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[4] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[5]) {
            if (miBarco6[0].getName().equals("undido") && miBarco6[1].getName().equals("undido") && miBarco6[2].getName().equals("undido") && miBarco6[3].getName().equals("undido")) {
                miBarco6[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco6[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco6[2].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco6[3].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[5] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[6]) {
            if (miBarco7[0].getName().equals("undido") && miBarco7[1].getName().equals("undido") && miBarco7[2].getName().equals("undido")) {
                miBarco7[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco7[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco7[2].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[6] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[7]) {
            if (miBarco8[0].getName().equals("undido") && miBarco8[1].getName().equals("undido")) {
                miBarco8[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                miBarco8[1].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[7] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[8]) {
            if (miBarco9[0].getName().equals("undido")) {
                miBarco9[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[8] = true;
                perdidos++;
                notifyObservers();
            }
        }
        if (!mibarcoundido[9]) {
            if (miBarco10[0].getName().equals("undido")) {
                miBarco10[0].setBackground(new Color(datocolor[0][3], datocolor[0][2], datocolor[0][1], datocolor[0][0]));
                mibarcoundido[9] = true;
                perdidos++;
                notifyObservers();
            }
        }
    }

    private boolean TiroRepetidoBase(JButton fire) {
        boolean OK = false;
        for (int i = 0; i < 225; i++) {
            if (ComputadoraTiro[i] == fire) {
                OK = true;
                break;
            }
        }
        return OK;
    }

    private void VerificarBarcoUndido(int x, int y) {
        JButton temp = BotonMapa[IdentificarBoton(x, y)];
        BotonMapa[IdentificarBoton(x, y)].setName("undido");
        if (!TiroRepetidoMapa(temp)) {
            MiTiro[t1++] = temp; // guardamos el tiro en una variable temporal
            PintarBoton(x, y);
            //Actualizar();
            MostrarsileDi(temp);
            MiTurno = false;
            HayGanador();
            TiempoDeRespuesta();
        } else {
            //JOptionPane.showMessageDialog(null, "repetiste -.-");
        }
    }

    private void ComputerBarcoUndido() {
        if (!computerbarcoundido[0]) {
            if (cptBarco1[0].getName().equals("undido") && cptBarco1[1].getName().equals("undido") && cptBarco1[2].getName().equals("undido") && cptBarco1[3].getName().equals("undido") && cptBarco1[4].getName().equals("undido")) {
                cptBarco1[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco1[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco1[2].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco1[3].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco1[4].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[0] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[1]) {
            if (cptBarco2[0].getName().equals("undido") && cptBarco2[1].getName().equals("undido") && cptBarco2[2].getName().equals("undido") && cptBarco2[3].getName().equals("undido")) {
                cptBarco2[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco2[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco2[2].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco2[3].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[1] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[2]) {
            if (cptBarco3[0].getName().equals("undido") && cptBarco3[1].getName().equals("undido") && cptBarco3[2].getName().equals("undido")) {
                cptBarco3[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco3[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco3[2].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[2] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[3]) {
            if (cptBarco4[0].getName().equals("undido") && cptBarco4[1].getName().equals("undido")) {
                cptBarco4[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco4[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[3] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[4]) {
            if (cptBarco5[0].getName().equals("undido") && cptBarco5[1].getName().equals("undido") && cptBarco5[2].getName().equals("undido") && cptBarco5[3].getName().equals("undido") && cptBarco5[4].getName().equals("undido")) {
                cptBarco5[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco5[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco5[2].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco5[3].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco5[4].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[4] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[5]) {
            if (cptBarco6[0].getName().equals("undido") && cptBarco6[1].getName().equals("undido") && cptBarco6[2].getName().equals("undido") && cptBarco6[3].getName().equals("undido")) {
                cptBarco6[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco6[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco6[2].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco6[3].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[5] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[6]) {
            if (cptBarco7[0].getName().equals("undido") && cptBarco7[1].getName().equals("undido") && cptBarco7[2].getName().equals("undido")) {
                cptBarco7[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco7[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco7[2].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[6] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[7]) {
            if (cptBarco8[0].getName().equals("undido") && cptBarco8[1].getName().equals("undido")) {
                cptBarco8[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                cptBarco8[1].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[7] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[8]) {
            if (cptBarco9[0].getName().equals("undido")) {
                cptBarco9[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[8] = true;
                hundidos++;
                notifyObservers();
            }
        }
        if (!computerbarcoundido[9]) {
            if (cptBarco10[0].getName().equals("undido")) {
                cptBarco10[0].setBackground(new Color(datocolor[1][3], datocolor[1][2], datocolor[1][1], datocolor[1][0]));
                computerbarcoundido[9] = true;
                hundidos++;
                notifyObservers();
            }
        }
    }

    private boolean TiroRepetidoMapa(JButton temp) {
        boolean OK = false;
        for (int i = 0; i < MiTiro.length; i++) {
            if (MiTiro[i] == temp) {
                OK = true;
                break;
            }
        }
        return OK;
    }

    private void PintarBoton(int x, int y) {
        BotonMapa[IdentificarBoton(x, y)].setBackground(new Color(datocolor[4][3], datocolor[4][2], datocolor[4][1], datocolor[4][0]));
    }

    private void DividirBarco() {
        archivo = new src.Clases.Archivo();
        tempc = new String[8];
        controles = new String[7];
        String palabra = archivo.leer("archivos/color.txt");
        Tokens(palabra);
        computerbarcoundido = new boolean[10];
        mibarcoundido = new boolean[10];
        cptBarco1 = new JButton[5];
        cptBarco2 = new JButton[4];
        cptBarco3 = new JButton[3];
        cptBarco4 = new JButton[2];
        cptBarco5 = new JButton[5];
        cptBarco6 = new JButton[4];
        cptBarco7 = new JButton[3];
        cptBarco8 = new JButton[2];
        cptBarco9 = new JButton[1];
        cptBarco10 = new JButton[1];
        miBarco1 = new JButton[5];
        miBarco2 = new JButton[4];
        miBarco3 = new JButton[3];
        miBarco4 = new JButton[2];
        miBarco5 = new JButton[5];
        miBarco6 = new JButton[4];
        miBarco7 = new JButton[3];
        miBarco8 = new JButton[2];
        miBarco9 = new JButton[1];
        miBarco10 = new JButton[1];
        for (int i = 0; i < 5; i++) {
            cptBarco1[i] = MemoricBoton[i];
            cptBarco5[i] = MemoricBoton[(i + 14)];
            miBarco1[i] = MemoricBase[i];
            miBarco5[i] = MemoricBase[(i + 14)];
        }
        for (int i = 0; i < 4; i++) {
            cptBarco2[i] = MemoricBoton[(i + 5)];
            cptBarco6[i] = MemoricBoton[(i + 19)];
            miBarco2[i] = MemoricBase[(i + 5)];
            miBarco6[i] = MemoricBase[(i + 19)];
        }
        for (int i = 0; i < 3; i++) {
            cptBarco3[i] = MemoricBoton[(i + 9)];
            cptBarco7[i] = MemoricBoton[(i + 23)];
            miBarco3[i] = MemoricBase[(i + 9)];
            miBarco7[i] = MemoricBase[(i + 23)];
        }
        for (int i = 0; i < 2; i++) {
            cptBarco4[i] = MemoricBoton[(i + 12)];
            cptBarco8[i] = MemoricBoton[(i + 26)];
            miBarco4[i] = MemoricBase[(i + 12)];
            miBarco8[i] = MemoricBase[(i + 26)];
        }
        cptBarco9[0] = MemoricBoton[28];
        cptBarco10[0] = MemoricBoton[29];
        miBarco9[0] = MemoricBase[28];
        miBarco10[0] = MemoricBase[29];

        for (int i = 0; i < BotonMapa.length; i++) {
            BotonMapa[i].setName(".");
            BotonBase[i].setName(".");
        }
        for (int i = 0; i < 10; i++) {
            computerbarcoundido[i] = false;
            mibarcoundido[i] = false;
        }
    }

    private int aleatorio() {
        int num = (int) (Math.random() * 225);
        return num;
    }

    private void Tokens(String palabra) {
        int d = 0;
        datocolor = new int[8][4];
        StringTokenizer token = new StringTokenizer(palabra, "%%%%");
        while (token.hasMoreTokens()) {
            tempc[d] = token.nextToken();
            d++;
        }
        for (int x = 0; x < 8; x++) {
            StringTokenizer t = new StringTokenizer(tempc[x], ",");
            int c = 0;
            while (t.hasMoreTokens()) {
                datocolor[x][c] = Integer.parseInt(t.nextToken());
                c++;
            }
        }
    }

    private String getTitulo() {
        String palabra = "";
        StringTokenizer token = new StringTokenizer(this.juego.getTitle(), "-");
        while (token.hasMoreTokens()) {
            palabra = token.nextToken();
            System.out.println(palabra);
        }
        return palabra;
    }

    public void TiempoDeRespuesta() {
        objTimer = new Timer(TiempoDemora(), new ClaseTimer());
        objTimer.start();
    }

    public class ClaseTimer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (time > 100) {
                objTimer.stop();
                TiroComputadora();
                time = 0;
            }
            time++;
        }
    }

    private int TiempoDemora() {
        int c = 0;
        String palabra = archivo.leer("archivos/Controles.txt");
        StringTokenizer token = new StringTokenizer(palabra, "%%%%");
        while (token.hasMoreTokens()) {
            controles[c] = token.nextToken();
            c++;
        }
        int tiem = Integer.parseInt(controles[1]);
        if (tiem == 5) {
            return 0;
        }
        if (tiem == 4) {
            return 1;
        }
        if (tiem == 3) {
            return 2;
        }
        if (tiem == 2) {
            return 3;
        }
        if (tiem == 1) {
            return 4;
        }
        return tiem;
    }

    private void Nivel() {
        Niveles niv = new Niveles(MemoricBase, BotonBase);
        niv.Iniciar();
        Nivel = niv.Nivel;
        NivelEscogido = niv.NivelPredeterminado();
    }

}
