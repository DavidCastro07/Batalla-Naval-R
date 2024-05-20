package Configuracion;

import Clases.Archivo;
import Interfaz.Configuracion;
import Interfaz.FontChooser;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;

public class Controles {
    
    Configuracion configuracion;
    Archivo archivo;
    String datos[];
    String temporal[];
    
    public Controles(Configuracion configuracion){
        this.configuracion = configuracion;
        archivo = new Archivo();
    }
    
    public void Iniciar(){
        LeerDatos();
        PonerDatos();
        this.configuracion.jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        this.configuracion.jTextField9.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField9ActionPerformed(e);
            }
        });
        this.configuracion.jButton10.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton10ActionPerformed(e);
            }
        });
        this.configuracion.jButton11.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton11ActionPerformed(e);
            }
        });
        this.configuracion.jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
    }
    
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {
        this.configuracion.jTextField9.setText(this.configuracion.jSlider1.getValue()+"");
    }
    
    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt){
        if(Integer.parseInt(this.configuracion.jTextField9.getText())>10){
            this.configuracion.jTextField9.setText("10");
        }else if(Integer.parseInt(this.configuracion.jTextField9.getText())<1){
            this.configuracion.jTextField9.setText("1");
        }
        this.configuracion.jSlider1.setValue(Integer.parseInt(this.configuracion.jTextField9.getText()));
    }
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt){
        // Guardamos Nivel
        if(this.configuracion.jRadioButton1.isSelected()){
            temporal[0] = "Facil";
        }else if(this.configuracion.jRadioButton2.isSelected()){
            temporal[0] = "Medio";
        }else if(this.configuracion.jRadioButton3.isSelected()){
            temporal[0] = "Dificil";
        }
        // Guardamos Velovidad
        temporal[1] = this.configuracion.jSlider1.getValue()+"";
        // Guardamos Sonido
//        if(this.configuracion.jCheckBox1.isSelected()){
            temporal[2] = "Activado";
//        }else if(this.configuracion.jCheckBox2.isSelected()){
            temporal[2] = "Desactivado";
//        }
        // Guardamos Comentario
        temporal[3] = this.configuracion.jTextArea1.getText();
        temporal[4] = this.configuracion.jTextArea1.getFont().getName();
        temporal[5] = this.configuracion.jTextArea1.getFont().getStyle()+"";
        temporal[6] = this.configuracion.jTextArea1.getFont().getSize()+"";
        
        String concatenar = temporal[0]+"%%%%"+temporal[1]+"%%%%"+temporal[2]+"%%%%"+temporal[3]+"%%%%"+temporal[4]+"%%%%"+temporal[5]+"%%%%"+temporal[6];
        
        archivo.crearTxt("archivos/Controles.txt", concatenar);
    }
    
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt){
        FontChooser font=new FontChooser(null, true);
        ChooserFont clas=new ChooserFont(font,configuracion);
        clas.Iniciar(datos[4],datos[5],datos[6]);
        font.setVisible(true);
    }
    
    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getExtendedKeyCode()==86 || evt.getExtendedKeyCode()==88) evt.consume();
    }
    
    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {
        int cadena=this.configuracion.jTextArea1.getText().length();
        this.configuracion.jLabel16.setText(cadena+"");
        PintarLabel(cadena);
    }
    
    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {
        if (this.configuracion.jTextArea1.getText().length()==500) evt.consume();
    }
    
    private void PintarLabel(int cadena){
        if(cadena<=9){
            this.configuracion.jLabel16.setText("00"+cadena+"/500");
        }
        if(cadena>=10 && cadena<=99){
            this.configuracion.jLabel16.setText("0"+cadena+"/500");
        }
        if(cadena>=100){
            this.configuracion.jLabel16.setText(cadena+"/500");
        }
    }
    
    private void LeerDatos(){
        String dato = archivo.leer("archivos/Controles.txt");
        Tokens(dato);
    }
    
    private void Tokens(String palabra) {
        int a = 0;
        datos = new String[7];
        temporal = new String[7];
        StringTokenizer token = new StringTokenizer(palabra, "%%%%");
        while (token.hasMoreTokens()) {
            datos[a] = token.nextToken();
            a++;
        }
    }
    
    private void PonerDatos(){
        // Pintamos Nivel
        if(datos[0].equalsIgnoreCase("Facil")){
            this.configuracion.jRadioButton1.setSelected(true);
        }else if(datos[0].equalsIgnoreCase("Medio")){
            this.configuracion.jRadioButton2.setSelected(true);
        }else if(datos[0].equalsIgnoreCase("Dificil")){
            this.configuracion.jRadioButton3.setSelected(true);
        }
        // Pintamos la Velocidad
        this.configuracion.jSlider1.setValue(Integer.parseInt(datos[1]));
        this.configuracion.jTextField9.setText(datos[1]);
        // Pintamos El Sonido
////        if(datos[2].equalsIgnoreCase("Activado")){
//            this.configuracion.jCheckBox1.setSelected(true);
////        }else if(datos[2].equalsIgnoreCase("Desactivado")){
//            this.configuracion.jCheckBox2.setSelected(true);
////        }
        // Pintamos Comentarios
        this.configuracion.jTextArea1.setText(datos[3]);
        this.configuracion.jTextArea1.setFont(new java.awt.Font(datos[4],Integer.parseInt(datos[5]),Integer.parseInt(datos[6])));
        PintarLabel(datos[3].length());
    }
        
}
