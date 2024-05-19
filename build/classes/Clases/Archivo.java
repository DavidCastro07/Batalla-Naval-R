package Clases;

import java.applet.AudioClip;
import java.io.*;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Archivo {

    File archivo;
    FileReader LeerArchivo;
    FileWriter EscribirArchivo;
    BufferedReader LeerBufer;
    BufferedWriter EscribirBufer;
    PrintWriter Imprimir;

    public void concatenar(String ruta, String texto) {
        String temp = leer(ruta);
        temp = temp + texto;
        crearTxt(ruta, temp);
    }

    public void crearTxt(String ruta, String texto) {
        try {
            archivo = new File(ruta);
            EscribirArchivo = new FileWriter(archivo);
            EscribirBufer = new BufferedWriter(EscribirArchivo);
            Imprimir = new PrintWriter(EscribirBufer);

            Imprimir.write(texto);

            Imprimir.close();
            EscribirBufer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error \n" + e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String leer(String ruta) {
        try {
            archivo = new File(ruta);
            LeerArchivo = new FileReader(archivo);
            LeerBufer = new BufferedReader(LeerArchivo);
            String l = "";
            String aux;
            while (true) {
                aux = LeerBufer.readLine();
                if (aux != null) {
                    l = l + aux;
                } else {
                    break;
                }
            }
            LeerBufer.close();
            return l;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error \n" + e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public String leerGrafico() {
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.showOpenDialog(j);
        try {
            String path = j.getSelectedFile().getAbsolutePath();
            String lectura = "";
            archivo = new File(path);
            try {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String aux;
                while ((aux = br.readLine()) != null) {
                    lectura = lectura + aux;
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error \n" + e.getMessage(), "Mensae de Error", JOptionPane.ERROR_MESSAGE);
            }
            return lectura;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Has Seleccionado Cerrar el Programa", "Saliendo", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        return null;
    }
    
    public void Sonido(String Ruta){
        //  "/Principal/java.wav"
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource(Ruta));
        System.out.println(Ruta);
        sonido.play();
    }
    
    public void Audio(){
        try {
            FileInputStream fis;
            Player player;
            fis = new FileInputStream("C:\\Users\\Fernando\\Desktop\\PonerBarco.mp3");
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
//            player.play();
            player.play(100);
        } catch (JavaLayerException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
