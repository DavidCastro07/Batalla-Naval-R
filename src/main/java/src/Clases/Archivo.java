package Clases;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;
import javax.swing.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Archivo {

    File archivo;
    FileReader LeerArchivo;
    FileWriter EscribirArchivo;
    BufferedReader LeerBufer;
    BufferedWriter EscribirBufer;
    PrintWriter Imprimir;
    private JFileChooser fileChooser;

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

    // Método setter para JFileChooser
    public void setFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;}

    public String leerGrafico() {

        fileChooser.showOpenDialog(fileChooser);
        try {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
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

    public void sonido(String ruta) throws SoundException {
        try {
            URL url = getClass().getResource(ruta); // Obtiene la URL del recurso
            if (url == null) {
                throw new SoundException("Error: No se encontró el recurso " + ruta);
            }
            AudioClip sonido = Applet.newAudioClip(url); // Crea un nuevo AudioClip desde la URL
            sonido.play(); // Reproduce el audio
        } catch (NullPointerException e) {
            throw new SoundException("Error: No se encontró el recurso " + ruta, e);
        }
    }

    public static class SoundException extends Exception {
        public SoundException(String message) {
            super(message);
        }

        public SoundException(String message, Throwable cause) {
            super(message, cause);
        }
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
