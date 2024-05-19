package Configuracion;

import Clases.Archivo;
import Interfaz.ColorGeneral;
import Interfaz.Configuracion;
import Interfaz.Juego;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import javax.swing.JButton;

public class ColorJuego {

    ColorGeneral colorgeneral;
    Configuracion configuracion;
    CentralConfiguracion centralconfiguracion;
    Juego juego;
    JButton BotonMuestra[];
    JButton Memoric[];
    String titulo;
    Color chooser;
    int red, green, blue, alpha;
    Archivo archivo;
    String concatenar;
    String temp[];
    int datocolor[][];
    String codigocolor[];

    public ColorJuego(ColorGeneral colorgeneral, JButton BotonMuestra[], String titulo, JButton Memoric[], Configuracion configuracion, Juego juego, CentralConfiguracion centralconfiguracion) {
        this.colorgeneral = colorgeneral;
        this.configuracion = configuracion;
        this.juego = juego;
        this.BotonMuestra = BotonMuestra;
        this.Memoric = Memoric;
        this.titulo = titulo;
        this.colorgeneral.setLocationRelativeTo(null);
        this.centralconfiguracion = centralconfiguracion;
    }

    public void Iniciar() {
        MostrarDato();
        this.colorgeneral.jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        chooser = this.colorgeneral.jColorChooser1.getColor();
        red = chooser.getRed();
        green = chooser.getGreen();
        blue = chooser.getBlue();
        alpha = chooser.getAlpha();
        
//        concatenar=alpha+","+blue+","+green+","+red;
        
        Pintar();
        
        archivo.crearTxt("archivos/color.txt", concatenar);        
        
        //archivo.crearTxt("C:/Users/Fernando/Desktop/EJERCICIOS EN JAVA/BatallaNaval/archivos/color.txt", concatenar); //para jar

        this.colorgeneral.dispose();
    }
    
    private void Pintar() {
        codigocolor();
        switch (titulo) {
            case "Mi Barco":
                for (int i = 0; i < 30; i++) {
                    BotonMuestra[i].setBackground(new Color(red, green, blue, alpha));
                }
                for (int i = 0; i < Memoric.length; i++) {
                    if (Memoric[i] != null) {
                        Memoric[i].setBackground(new Color(red, green, blue, alpha));
                    }
                }
                this.configuracion.jTextField7.setText(alpha+","+blue+","+green+","+red);

                concatenar = temp[0] + "%%%%" + temp[1] + "%%%%" + temp[2] + "%%%%" + temp[3] + "%%%%" + temp[4] + "%%%%" + temp[5] + "%%%%"
                        + alpha + "," + blue + "," + green + "," + red + "%%%%" + temp[7];
                break;
            case "Mi Tiro": 
                this.configuracion.jTextField5.setText(alpha+","+blue+","+green+","+red);
                concatenar = temp[0] + "%%%%" + temp[1] + "%%%%" + temp[2] + "%%%%" + temp[3] + "%%%%" + alpha + "," + blue + "," + green + "," + red + "%%%%"
                        + temp[5] + "%%%%" + temp[6] + "%%%%" + temp[7];
                break;
            case "Tiro Enemigo":
                this.configuracion.jTextField6.setText(alpha+","+blue+","+green+","+red);
                concatenar = temp[0] + "%%%%" + temp[1] + "%%%%" + temp[2] + "%%%%" + temp[3] + "%%%%" + temp[4] + "%%%%" +
                         alpha + "," + blue + "," + green + "," + red + "%%%%" + temp[6] + "%%%%" + temp[7];
                break;
            case "Barco Enemigo Dañado":
                this.configuracion.jTextField4.setText(alpha+","+blue+","+green+","+red);
                concatenar = temp[0] + "%%%%" + temp[1] + "%%%%" + temp[2] + "%%%%" + alpha + "," + blue + "," + green + "," + red +
                        "%%%%" + temp[4] + "%%%%" + temp[5] + "%%%%" + temp[6] + "%%%%" + temp[7];
                break;
            case "Mi Barco Dañado":
                this.configuracion.jTextField3.setText(alpha+","+blue+","+green+","+red);
                concatenar = temp[0] + "%%%%" + temp[1] + "%%%%" + alpha + "," + blue + "," + green + "," + red + "%%%%" + 
                        temp[3] + "%%%%" + temp[4] + "%%%%" + temp[5] + "%%%%" + temp[6] + "%%%%" + temp[7];
                break;
            case "Mi Barco Hundido":
                this.configuracion.jTextField1.setText(alpha+","+blue+","+green+","+red);
                concatenar = alpha + "," + blue + "," + green + "," + red + "%%%%" + temp[1] + "%%%%" + temp[2] + "%%%%" + 
                        temp[3] + "%%%%" + temp[4] + "%%%%" + temp[5] + "%%%%" + temp[6] + "%%%%" + temp[7];
                break;
            case "Barco Enemigo Hundido":
                this.configuracion.jTextField2.setText(alpha+","+blue+","+green+","+red);
                concatenar = temp[0] + "%%%%" + alpha + "," + blue + "," + green + "," + red + "%%%%" + temp[2] + "%%%%" + 
                        temp[3] + "%%%%" + temp[4] + "%%%%" + temp[5] + "%%%%" + temp[6] + "%%%%" + temp[7];                
                break;
            case "Fondo Juego":
                this.configuracion.jTextField8.setText(alpha+","+blue+","+green+","+red);
                concatenar = temp[0] + "%%%%" + temp[1] + "%%%%" + temp[2] + "%%%%" + temp[3] + "%%%%" + temp[4] + "%%%%" + temp[5] + "%%%%" + temp[6] + "%%%%" 
                        + alpha + "," + blue + "," + green + "," + red ;
                this.juego.PanelJuego.setBackground(new Color(red, green, blue, alpha));
                break;
            default:
                break;
        }
    }

    private void codigocolor() {
        int c = 0;
        codigocolor = new String[8];
        String palabra = archivo.leer("archivos/color.txt");
        StringTokenizer token = new StringTokenizer(palabra, "%%%%");
        while (token.hasMoreTokens()) {
            codigocolor[c] = token.nextToken();
            c++;
        }
    }

    private void MostrarDato() {
        archivo = new Archivo();
        temp = new String[8];
        String palabra = archivo.leer("archivos/color.txt");
        Tokens(palabra);
        switch (titulo) {
            case "Mi Barco":
                this.colorgeneral.jColorChooser1.setColor(new Color(datocolor[6][3], datocolor[6][2], datocolor[6][1], datocolor[6][0]));
                break;
            default:
                break;
        }
    }

    private void Tokens(String palabra) {
        int a = 0;
        datocolor = new int[8][4];
        StringTokenizer token = new StringTokenizer(palabra, "%%%%");
        while (token.hasMoreTokens()) {
            temp[a] = token.nextToken();
            a++;
        }
        for (int x = 0; x < 8; x++) {
            StringTokenizer t = new StringTokenizer(temp[x], ",");
            int c = 0;
            while (t.hasMoreTokens()) {
                datocolor[x][c] = Integer.parseInt(t.nextToken());
                c++;
            }
        }
    }
}
