package src.Clases;

import src.Configuracion.CentralConfiguracion;
import src.Interfaz.Configuracion;
import src.Interfaz.Juego;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ControlMovimiento {
    
    private Juego juego;
    src.Clases.Archivo archivo;
    
    JButton BotonMapa[];
    JButton BotonBase[];
    JButton BotonMuestra[];
    JButton BotonSelecionado[];
    JButton MemoricBoton[]=new JButton[30];
    
    Color pred;
    Color colorenemigo;
    boolean MisBarcos[];
    boolean CLICK=false;
    boolean DETENER=false;
    
    String temp[]=new String[8];
    int datocolor[][]=new int [8][4];
                    
    public ControlMovimiento(Juego juego, JButton botonbase[], JButton botonmapa[], JButton BotonMuestra[]){
        this.juego=juego;
        this.BotonBase=botonbase;
        this.BotonMapa=botonmapa;
        this.BotonMuestra=BotonMuestra;
    }
    
    public void Iniciar(){
        pred=juego.jEmpezar.getBackground();
        for (int i=0;i<225;i++){
            BotonBase[i].addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt){
                    BotonBaseMouseEntered(evt);                   
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt){
                    BotonBaseMouseExited(evt);
                };
            });
            BotonBase[i].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    BotonBaseActionPerformed(evt);
                }
            });
        }
        this.juego.jConfiguracion.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jButton474ActionPerformed(e);
                }
        });
        LlenarDatos();
    }
    
    private void LlenarDatos(){
        MisBarcos=new boolean[10];
        for(int i=0;i<8;i++) MisBarcos[i]=false;
    }
    
    public void ColorEnemigo(Color color){
        colorenemigo = color;
    }
    
    private void jButton474ActionPerformed(java.awt.event.ActionEvent evt){
        Configuracion configuracion=new Configuracion(juego, true);
        CentralConfiguracion principal=new CentralConfiguracion(configuracion,BotonMuestra,MemoricBoton,juego);
        principal.Iniciar();
        configuracion.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" IDENTIFICAR BOTON POR MEDIO DE LA POSICION ">
    private int IdentificarBoton(int x, int y){                         //     ←        ↑       →      ↓
        int numero=0;
        for(int i=0;i<15;i++){
            if(x>=10 && y>=(i*25)+24 && x<35 && y<(i*25)+49){ // izquierda, arriba, derecha, abajo
                numero=(i*15);
            }else if (x>=35 && y>=(i*25)+24 && x<60 && y<(i*25)+49){
                numero=(i*15)+1;
            }else if (x>=60 && y>=(i*25)+24 && x<85 && y<(i*25)+49){
                numero=(i*15)+2;
            }else if (x>=85 && y>=(i*25)+24 && x<110 && y<(i*25)+49){
                numero=(i*15)+3;
            }else if (x>=110 && y>=(i*25)+24 && x<135 && y<(i*25)+49){
                numero=(i*15)+4;
            }else if (x>=135 && y>=(i*25)+24 && x<160 && y<(i*25)+49){
                numero=(i*15)+5;
            }else if (x>=160 && y>=(i*25)+24 && x<185 && y<(i*25)+49){
                numero=(i*15)+6;
            }else if (x>=185 && y>=(i*25)+24 && x<210 && y<(i*25)+494){
                numero=(i*15)+7;
            }else if (x>=210 && y>=(i*25)+24 && x<235 && y<(i*25)+49){
                numero=(i*15)+8;
            }else if (x>=235 && y>=(i*25)+24 && x<260 && y<(i*25)+49){
                numero=(i*15)+9;
            }else if (x>=260 && y>=(i*25)+24 && x<285 && y<(i*25)+49){
                numero=(i*15)+10;
            }else if (x>=285 && y>=(i*25)+24 && x<310 && y<(i*25)+49){
                numero=(i*15)+11;
            }else if (x>=310 && y>=(i*25)+24 && x<335 && y<(i*25)+49){
                numero=(i*15)+12;
            }else if (x>=335 && y>=(i*25)+24 && x<360 && y<(i*25)+49){
                numero=(i*15)+13;
            }else if (x>=360 && y>=(i*25)+24 && x<385 && y<(i*25)+49){
                numero=(i*15)+14;
            }
        }
        return numero;
    }
    //</editor-fold>
    
    private void memorizando(String cmd){
        switch (cmd){
            case "Primero":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 0, 5);  //  for(int i=0;i<5;i++)    MemoricBoton[i]=BotonSelecionado[i]; 
                break;
            case "Segundo":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 5, 4);  //  for(int i=0;i<4;i++)    MemoricBoton[i+5]=BotonSelecionado[i];
                break;
            case "Tercero":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 9, 3);  //  for(int i=0;i<3;i++)    MemoricBoton[i+9]=BotonSelecionado[i];
                break;
            case "Cuarto":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 12, 2); //  for(int i=0;i<2;i++)    MemoricBoton[i+12]=BotonSelecionado[i];
                break;
            case "Quinto":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 14, 5); //  for(int i=0;i<5;i++)    MemoricBoton[i+14]=BotonSelecionado[i];
                break;
            case "Sexto":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 19, 4); //  for(int i=0;i<4;i++)    MemoricBoton[i+19]=BotonSelecionado[i];
                break;
            case "Septimo":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 23, 3); //  for(int i=0;i<3;i++)    MemoricBoton[i+23]=BotonSelecionado[i];
                break;
            case "Octavo":
                System.arraycopy(BotonSelecionado, 0, MemoricBoton, 26, 2); //  for(int i=0;i<2;i++)    MemoricBoton[i+26]=BotonSelecionado[i];
                break;
            case "Noveno":
                MemoricBoton[28]=BotonSelecionado[0];
                break;
            case "Decimo":
                MemoricBoton[29]=BotonSelecionado[0];
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ocurio un error al guardar posicion del Barco","Mensaje de Error",JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    private void BotonBaseActionPerformed(java.awt.event.ActionEvent evt){
        if (!DETENER){
            if(NoRepetir(BotonSelecionado)){
                CLICK=true;
                if(!MisBarcos[0]){
                    memorizando("Primero");
                    MisBarcos[0]=true;
                }else if(!MisBarcos[1]){
                    memorizando("Segundo");
                    MisBarcos[1]=true;
                }else if(!MisBarcos[2]){
                    memorizando("Tercero");
                    MisBarcos[2]=true;
                }else if(!MisBarcos[3]){
                    memorizando("Cuarto");
                    MisBarcos[3]=true;
                }else if(!MisBarcos[4]){
                    memorizando("Quinto");
                    MisBarcos[4]=true;
                }else if(!MisBarcos[5]){
                    memorizando("Sexto");
                    MisBarcos[5]=true;
                }else if(!MisBarcos[6]){
                    memorizando("Septimo");
                    MisBarcos[6]=true;
                }else if(!MisBarcos[7]){
                    memorizando("Octavo");
                    MisBarcos[7]=true;
                }else if(!MisBarcos[8]){
                    memorizando("Noveno");
                    MisBarcos[8]=true;
                }else if(!MisBarcos[9]){
                    memorizando("Decimo");
                    MisBarcos[9]=true;
                    BarcosEnemigos();
                }
            }else{
                JOptionPane.showMessageDialog(null, "No puede haber dos o mas barcos en la misma casilla","Mensaje de Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void BotonBaseMouseEntered(java.awt.event.MouseEvent evt) {
        try{
            int x=juego.jPanel2.getMousePosition().getLocation().x;
            int y=juego.jPanel2.getMousePosition().getLocation().y;
            if (!DETENER){
                if(!MisBarcos[0]){
                    PintarTabla("Primero", x, y);
                }else if(!MisBarcos[1]){
                    PintarTabla("Segundo", x, y);
                }else if(!MisBarcos[2]){
                    PintarTabla("Tercero", x, y);
                }else if(!MisBarcos[3]){
                    PintarTabla("Cuarto", x, y);
                }else if(!MisBarcos[4]){
                    PintarTabla("Quinto", x, y);
                }else if(!MisBarcos[5]){
                    PintarTabla("Sexto", x, y);
                }else if(!MisBarcos[6]){
                    PintarTabla("Septimo", x, y);
                }else if(!MisBarcos[7]){
                    PintarTabla("Octavo", x, y);
                }else if(!MisBarcos[8]){
                    PintarTabla("Noveno", x, y);
                }else if(!MisBarcos[9]){
                    PintarTabla("Decimo", x, y);
                }
            }
        }catch(NullPointerException e){}
    }
    
    private void BotonBaseMouseExited(java.awt.event.MouseEvent evt) {
        if(!DETENER){
            JButton cap[]=GetSeleccionarBotones();
            if(!CLICK){ // si es false
                for(int i=0;i<cap.length;i++){
                VerificarRepetida(cap[i]);
                }
            }else{ // si es true
                CLICK=false;
            }
        }
    }
    
    private void VerificarRepetida(JButton boton){
        for(int i=0;i<30;i++){
            if(MemoricBoton[i]==boton){
                boton.setBackground(getColor());
                break;
            }else{
                boton.setBackground(pred);
            }
        }
    }
    
    private boolean NoRepetir(JButton boton[]){
        boolean OK=true;
        for(int i=0;i<boton.length;i++){
            for(int j=0;j<30;j++){
                if(boton[i]==MemoricBoton[j]){
                    OK=false;
                    break;
                }
            }
        }
        return OK;
    }
    
    private void BarcosEnemigos(){
        if (true){
            JOptionPane.showMessageDialog(null, "Espera! \n Colocando Barcos Enemigos... ","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            BarcosEnemigos enemigos = new BarcosEnemigos(juego, BotonMapa, BotonBase, MemoricBoton,this);
            enemigos.Iniciar();
        }
        DETENER=true;
    }
    
    private void SetSeleccionarBotones(JButton boton[]){
        BotonSelecionado=boton;
        for(int i=0;i<boton.length;i++){
            boton[i].setBackground(getColor());
        }
    }
    
    private Color getColor(){
        archivo = new src.Clases.Archivo();
        String variable = archivo.leer("archivos/color.txt");
        Tokens(variable);
        Color c=(new Color(datocolor[6][3], datocolor[6][2], datocolor[6][1], datocolor[6][0]));
        return c;
    }
    
    private void Tokens(String palabra){
        int a=0;
        StringTokenizer token = new StringTokenizer(palabra,"%%%%");
        while(token.hasMoreTokens()){
            temp[a]=token.nextToken();
            a++;
        }
        for(int x=0;x<8;x++){
            StringTokenizer t=new StringTokenizer(temp[x],",");
            int c=0;
            while(t.hasMoreTokens()){
                datocolor[x][c]=Integer.parseInt(t.nextToken());
                c++;
            }
        }
    }
        
    private JButton [] GetSeleccionarBotones(){
        return BotonSelecionado;
    }

    private void PintarTabla(String Tipo, int x, int y){    //     ←        ↑       →      ↓
        for(int i=0;i<15;i++){
            switch (Tipo){
                case "Primero":
                    if(x>=260 && y>=((i*25)+24) && x<=384 && y<((i*25)+49)){
                        JButton cap[]={BotonBase[(i*15)+10],BotonBase[(i*15)+11],BotonBase[(i*15)+12],BotonBase[(i*15)+13],BotonBase[(i*15)+14]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<260 && y<=398){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)], BotonBase[IdentificarBoton(x, y)+1],BotonBase[IdentificarBoton(x, y)+2],BotonBase[IdentificarBoton(x, y)+3],BotonBase[IdentificarBoton(x, y)+4]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Segundo":
                    if(x>=285 && y>=((i*25)+24) && x<=384 && y<((i*25)+49)){
                        JButton cap[]={BotonBase[(i*15)+11],BotonBase[(i*15)+12],BotonBase[(i*15)+13],BotonBase[(i*15)+14]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<285 && y<=398){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)], BotonBase[IdentificarBoton(x, y)+1], BotonBase[IdentificarBoton(x, y)+2], BotonBase[IdentificarBoton(x, y)+3]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Tercero":
                    if(x>=310 && y>=((i*25)+24) && x<=384 && y<((i*25)+49)){
                        JButton cap[]={BotonBase[(i*15)+12],BotonBase[(i*15)+13],BotonBase[(i*15)+14]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<310 && y<=398){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)], BotonBase[IdentificarBoton(x, y)+1],BotonBase[IdentificarBoton(x, y)+2]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Cuarto":
                    if(x>=335 && y>=((i*25)+24) && x<=384 && y<((i*25)+49)){
                        JButton cap[]={BotonBase[(i*15)+13], BotonBase[(i*15)+14]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<335 && y<=398){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)], BotonBase[IdentificarBoton(x, y)+1]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Quinto":
                    if(x>=(i*25)+10 && y>=274 && x<(i*25)+35 && y<=398){
                        JButton cap[]={BotonBase[i+150],BotonBase[i+165],BotonBase[i+180],BotonBase[i+195],BotonBase[i+210]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<=384 && y<274){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)], BotonBase[IdentificarBoton(x, y)+15],BotonBase[IdentificarBoton(x, y)+30],BotonBase[IdentificarBoton(x, y)+45],BotonBase[IdentificarBoton(x, y)+60]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Sexto":
                    if(x>=(i*25)+10 && y>=299 && x<(i*25)+35 && y<=398){
                        JButton cap[]={BotonBase[i+165],BotonBase[i+180],BotonBase[i+195],BotonBase[i+210]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<=384 && y<299){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)], BotonBase[IdentificarBoton(x, y)+15], BotonBase[IdentificarBoton(x, y)+30],BotonBase[IdentificarBoton(x, y)+45]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Septimo":
                    if(x>=(i*25)+10 && y>=324 && x<(i*25)+35 && y<=398){
                        JButton cap[]={BotonBase[i+180],BotonBase[i+195],BotonBase[i+210]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<=384 && y<324){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)],BotonBase[IdentificarBoton(x, y)+15],BotonBase[IdentificarBoton(x, y)+30]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Octavo":
                    if(x>=(i*25)+10 && y>=349 && x<(i*25)+35 && y<398){
                        JButton cap[]={BotonBase[i+195],BotonBase[i+210]};
                        SetSeleccionarBotones(cap);
                    }else if(x>=10 && y>=24 && x<=384 && y<349){
                        JButton cap[]={BotonBase[IdentificarBoton(x, y)],BotonBase[IdentificarBoton(x, y)+15]};
                        SetSeleccionarBotones(cap);
                    }
                    break;
                case "Noveno":
                    JButton capA[]={BotonBase[IdentificarBoton(x, y)]};
                    SetSeleccionarBotones(capA);
                    break;
                case "Decimo":
                    JButton capB[]={BotonBase[IdentificarBoton(x, y)]};
                    SetSeleccionarBotones(capB);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡Este Barco no se encuentra en el Juego!","Mensaje de Error",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}