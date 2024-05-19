package Clases;

import java.util.StringTokenizer;
import javax.swing.JButton;

public class Niveles {
    
    JButton MemoricBase[];
    JButton Tablero[];
    StringTokenizer token;
    Archivo archivo;
    String controles[];
    int tamaño=0;
    JButton Tiros[];
    
    String Nivel;
    JButton NivelMedio[];
    JButton NivelDificil[];
    
    public Niveles(JButton MemoricBase[], JButton Tablero[]){
        this.MemoricBase = MemoricBase;
        this.Tablero = Tablero;
    }
    
    public void Iniciar(){
        archivo = new Archivo();
        controles = new String[7];
        Tiros = new JButton[225];
        NivelMedio = new JButton[225];
        NivelDificil = new JButton[225];
        ContruirTirosOrdenados();
        Nivel();
    }
    
    private void ContruirTirosOrdenados(){
        Llenar_Datos_Existentes();
        JButton temporal[]=new JButton[195];
        int a=0,c=30;
        for(int i=0;i<225;i++){
            if(!existe(Tablero[i])){
                temporal[a] = Tablero[i];
                a++;
            }
        }        
        JButton desordenar_temporal[]= desordenar_Barco(temporal);
        for(int i=0;i<195;i++){
            Tiros[c]=desordenar_temporal[i];
            c++;
        }
    }
    
    private boolean existe(JButton dato){
        boolean Ok=false;
        for(int i=0;i<Tiros.length;i++){
            if(Tiros[i]==dato){
                Ok=true;
                break;
            }
        }
        return Ok;
    }
    
    private void Llenar_Datos_Existentes(){
        for(int i=0;i<MemoricBase.length;i++){
            Tiros[i] = MemoricBase[i];
        }
    }
    
    private void Nivel(){
        String nivel = GetNivel();
        if(nivel.equalsIgnoreCase("﻿Medio") || nivel.equalsIgnoreCase("Medio")){
            // Partimos los datos en dos, en el "A" contiene las posiciones de mis Barcos, en el "B" contiene datos Falsos
            JButton datoA[]=Partir_A(150);
            JButton datoB[]=Partir_B(150,75);
            // Lo Mesclamos xD
            JButton Tiro_A[]=desordenar_Barco(datoA);
            JButton Tiro_B[]=desordenar_Barco(datoB);
            NivelMedio = UnirTiros(Tiro_A, Tiro_B);
            Nivel="Medio";
        }else if(nivel.equalsIgnoreCase("﻿Dificil") || nivel.equalsIgnoreCase("Dificil")){
            JButton datoA[]=Partir_A(100);
            JButton datoB[]=Partir_B(100,125);
            JButton Tiro_A[]=desordenar_Barco(datoA);
            JButton Tiro_B[]=desordenar_Barco(datoB);
            NivelDificil = UnirTiros(Tiro_A, Tiro_B);
            Nivel="Dificil";
        }else if(nivel.equalsIgnoreCase("﻿Facil") || nivel.equalsIgnoreCase("Facil")){
            NivelDificil = null;
            Nivel="Facil";
        }
    }
    
    public JButton[] NivelPredeterminado(){
        if(Nivel.equalsIgnoreCase("Medio")){
            return NivelMedio;
        }else if(Nivel.equalsIgnoreCase("Dificil")){
            return NivelDificil;
        }
        return null;
    }
    
    private JButton[] UnirTiros(JButton Tiro_A[], JButton Tiro_B[]){
        int tamañoA = Tiro_A.length;
        JButton datofinal[] = new JButton[225];
        for(int i=0;i<tamañoA;i++){
            datofinal[i]=Tiro_A[i];
        }
        for(int i=0;i<Tiro_B.length;i++){
            datofinal[(tamañoA+i)]=Tiro_B[i];
        }
        return datofinal;
    }
    
    private JButton [] Partir_A(int n){
        JButton dato_a[] = new JButton[n];
        for(int i=0;i<n;i++){
            dato_a[i] = Tiros[i];
        }
        return dato_a;
    }
    
    private JButton []Partir_B(int n,int x){
        JButton dato_b[] = new JButton[x];
        for(int i=0;i<x;i++){
            dato_b[i]= Tiros[(i+n)];
        }
        return dato_b;
    }
       
    private String GetNivel(){
        String palabra = archivo.leer("archivos/Controles.txt");
        token = new StringTokenizer(palabra, "%%%%");
        while (token.hasMoreTokens()) {
             controles[tamaño] = token.nextToken();
             tamaño++;
         }
        return controles[0];
    }   
    
    public JButton []desordenar_Barco(JButton arregloInt[]){        
        int lista_elem = arregloInt.length;        
        int [] indice= new int [lista_elem]; 
        JButton desordenado[]= new JButton[lista_elem]; 
        
        int des_elem=0; 
        int aleatorio;
        
        for (int i=0;i<lista_elem;i++){
            indice[i]=i;
        }
        
        for (int i=lista_elem;i>0;i--){
            aleatorio=(int)(Math.random()*i); 
            desordenado[des_elem++]=arregloInt[indice[aleatorio]]; 
            for (int j=aleatorio;j<i-1;j++){
                indice[j]=indice[j+1];
            }
        }
        for (int i=0;i<lista_elem;i++){
            arregloInt[i]=desordenado[i];
        }
        return desordenado;
    }
    
}
