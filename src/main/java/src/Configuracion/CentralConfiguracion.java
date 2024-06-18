package src.Configuracion;

import src.Clases.Archivo;
import src.Interfaz.ColorGeneral;
import src.Interfaz.Configuracion;
import src.Interfaz.Juego;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import javax.swing.JButton;

public class CentralConfiguracion {
    
    Configuracion configuracion;
    Juego juego;
    JButton BotonMuestra[];
    JButton Memoric[];
    Archivo archivo;
    String codigocolor[];
    
    public CentralConfiguracion(Configuracion configuracion, JButton BotonMuestra[], JButton Memoric[],Juego juego){
        this.configuracion=configuracion;
        this.juego=juego;
        this.BotonMuestra=BotonMuestra;
        this.Memoric=Memoric;
        this.configuracion.setLocationRelativeTo(null);
    }
        
    //<editor-fold defaultstate="collapsed" desc=" Eventos de Botones ">
    public void Iniciar(){
        DatosColor();
        this.configuracion.jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });
        this.configuracion.jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });
        this.configuracion.jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed(e);
            }
        });
        this.configuracion.jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton4ActionPerformed(e);
            }
        });
        this.configuracion.jButton5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton5ActionPerformed(e);
            }
        });
        this.configuracion.jButton6.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton6ActionPerformed(e);
            }
        });
        this.configuracion.jButton7.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton7ActionPerformed(e);
            }
        });
        this.configuracion.jButton8.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton8ActionPerformed(e);
            }
        });
        this.configuracion.jButton9.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton9ActionPerformed(e);
            }
        });
        Controles controles =new Controles(configuracion);
        controles.Iniciar();
    }
    //</editor-fold>
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
        this.configuracion.dispose();
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Mi Barco Hundido", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Barco Enemigo Hundido", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Mi Barco Dañado", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Barco Enemigo Dañado", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Mi Tiro", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Tiro Enemigo", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Mi Barco", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt){
        ColorGeneral newj=new ColorGeneral(null, true);
        ColorJuego c=new ColorJuego(newj, BotonMuestra, "Fondo Juego", Memoric,configuracion,juego,this);
        c.Iniciar();
        newj.setVisible(true);
    }
        
    private void DatosColor(){
        archivo = new Archivo();
        codigocolor = new String[8];
        int c=0;
        String palabra = archivo.leer("archivos/color.txt");
        StringTokenizer token = new StringTokenizer(palabra,"%%%%");
        while(token.hasMoreTokens()){
            codigocolor[c]=token.nextToken();
            c++;
        }
        imprimir();
    }
    
    private void imprimir(){
        this.configuracion.jTextField1.setText(codigocolor[0]);
        this.configuracion.jTextField2.setText(codigocolor[1]);
        this.configuracion.jTextField3.setText(codigocolor[2]);
        this.configuracion.jTextField4.setText(codigocolor[3]);
        this.configuracion.jTextField5.setText(codigocolor[4]);
        this.configuracion.jTextField6.setText(codigocolor[5]);
        this.configuracion.jTextField7.setText(codigocolor[6]);
        this.configuracion.jTextField8.setText(codigocolor[7]);
    }
    
}
