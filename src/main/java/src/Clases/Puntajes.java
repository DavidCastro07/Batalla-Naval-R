package src.Clases;

import src.Interfaz.Clasificacion;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Puntajes {
    
    Clasificacion clasificacion;    
    DefaultTableModel tabla;
    LinkedList lista;
    src.Clases.Archivo archivo;
    StringTokenizer token;
    
    public Puntajes(Clasificacion clasificacion){
        this.clasificacion=clasificacion;
        lista = new LinkedList();
        tabla = new DefaultTableModel();
        archivo = new src.Clases.Archivo();
        this.clasificacion.jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }

        });
    }
    
    public void Iniciar(){
        this.clasificacion.jTable1.setModel(tabla);
        String titulo[]={"Jugador","Tiempo","Nivel"};
        tabla.setColumnIdentifiers(titulo);
        String palabra = archivo.leer("archivos/Clasificacion.txt");
        token = new StringTokenizer(palabra,"%%%%");
        while(token.hasMoreTokens()){
            lista.add(token.nextToken());
        }
        int tamaño  = lista.size();
        for (int i=0;i<tamaño/3;i++){
            Object dato[]={lista.get(i*3),lista.get((i*3)+1),lista.get((i*3)+2)};
            tabla.addRow(dato);
        }
        TableRowSorter<TableModel> ordenar=new TableRowSorter<TableModel>(tabla);
        this.clasificacion.jTable1.setRowSorter(ordenar);
        this.clasificacion.jTable1.setModel(tabla);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
        int accion = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar el Historial?","Mensaje de Información",JOptionPane.ERROR_MESSAGE);
        if(accion == 0){
            archivo.crearTxt("archivos/Clasificacion.txt", "");
            try {
                int filas = this.clasificacion.jTable1.getRowCount();
                for (int i = 0; filas > i; i++) {
                    tabla.removeRow(0);
                }
            }catch (Exception e) {}
        }
    }
}
        