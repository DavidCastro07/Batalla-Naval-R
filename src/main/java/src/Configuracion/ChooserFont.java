package src.Configuracion;

import src.Interfaz.Configuracion;
import src.Interfaz.FontChooser;
import java.awt.event.ActionEvent;

public class ChooserFont {
    
    FontChooser fontchooser;
    Configuracion configuracion;
    
    public ChooserFont(FontChooser fontchooser,Configuracion configuracion){
        this.fontchooser=fontchooser;
        this.configuracion=configuracion;
        this.fontchooser.setLocationRelativeTo(null);
        this.fontchooser.setTitle("Formato");
    }
    
    public void Iniciar(String name, String style, String size){
        fontchooser.jButton1.addActionListener(new java.awt.event.ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               jButton1ActionPerformed(e);
            } 
        });
        this.fontchooser.jFontChooser1.setFont(new java.awt.Font(name, Integer.parseInt(style), Integer.parseInt(size)));
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
        String name = fontchooser.jFontChooser1.getSelectedFont().getName();
        int style = fontchooser.jFontChooser1.getSelectedFont().getStyle();
        int size = fontchooser.jFontChooser1.getSelectedFont().getSize();
        this.configuracion.jTextArea1.setFont(new java.awt.Font(name,style,size));
        fontchooser.dispose();
    }
    
}
