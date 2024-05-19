package Clases;

import Interfaz.Juego;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.Timer;

public final class Efecto {
    
    public JButton BotonBase[];
    public JButton BotonMapa[];
    public JButton Muestra[];
    private Juego juego;
    
    private Timer objTimer;
    private int i=0,j=0;
    private int tt=0;
    
    String temp[];
    int datocolor[][];
    
    Archivo archivo;
    
    Color colores[]={Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.WHITE};
    Color pred;
        
    public Efecto(Juego juego){
        this.juego=juego;
        
        Declarar_BotonBase();
        Declarar_BotonMapa();
        BarcosMuestra();
        PintarMuestra();
        pred=BotonBase[0].getBackground();
        ocultar(false);
        objTimer = new Timer(25,new ClaseTimer());
        objTimer.start();  
    }
    
    private class ClaseTimer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(j>4){
                objTimer.stop();
                for(i=0;i<225;i++){
                    BotonBase[i].setBackground(pred);
                    BotonMapa[i].setBackground(pred);
                }
            }else{
                efecto_corrido();
                //efecto_barrido(colores[j]);
            }
        }
    }
    
    private void ocultar(boolean accion){
        this.juego.jClasificacion.setEnabled(accion);
        this.juego.jConfiguracion.setEnabled(accion);
        this.juego.jEmpezar.setEnabled(accion);
        this.juego.jReiniciar.setEnabled(accion);
        this.juego.jSalir.setEnabled(accion);
    }
    
    private void efecto_corrido(){
        if(tt>100){
            this.juego.jProgressBar1.setVisible(false);
            objTimer.stop();
            ocultar(true);
            int x = this.juego.getLocation().x;
            int y = this.juego.getLocation().y;
            int height = this.juego.getBounds().height;
            int width = this.juego.getBounds().width;
            this.juego.setBounds(x, y, width, height-25);
        }else{
            this.juego.jProgressBar1.setValue(tt);
        }
        tt++;
    }
    
    private void efecto_barrido(Color color){
        if(i<225){
            BotonBase[i].setBackground(color);
            BotonMapa[i].setBackground(color);
            i++;
        }else{
             i=0;
             j++;
        }
    }
    
    private void PintarMuestra(){
        archivo = new Archivo();
        temp=new String[8];
        String variable = archivo.leer("archivos/color.txt");
        tokens(variable);
        this.juego.PanelJuego.setBackground(new Color(datocolor[7][3], datocolor[7][2], datocolor[7][1], datocolor[7][0]));
        for(int x=0;x<Muestra.length;x++){
            Muestra[x].setBackground(new Color(datocolor[6][3], datocolor[6][2], datocolor[6][1], datocolor[6][0]));            
        }
    }
    
    private void tokens(String palabra){
        int a=0;
        datocolor = new int [8][4];
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
    
    private void BarcosMuestra(){
        Muestra = new JButton[30];
        
        Muestra[0]=this.juego.jButton451;
        Muestra[1]=this.juego.jButton452;
        Muestra[2]=this.juego.jButton453;
        Muestra[3]=this.juego.jButton454;
        Muestra[4]=this.juego.jButton455;
        Muestra[5]=this.juego.jButton456;
        Muestra[6]=this.juego.jButton457;
        Muestra[7]=this.juego.jButton458;
        Muestra[8]=this.juego.jButton459;
        Muestra[9]=this.juego.jButton460;
        Muestra[10]=this.juego.jButton461;
        Muestra[11]=this.juego.jButton462;
        Muestra[12]=this.juego.jButton463;
        Muestra[13]=this.juego.jButton464;
        Muestra[14]=this.juego.jButton465;
        Muestra[15]=this.juego.jButton466;
        Muestra[16]=this.juego.jButton467;
        Muestra[17]=this.juego.jButton468;
        Muestra[18]=this.juego.jButton469;
        Muestra[19]=this.juego.jButton470;
        Muestra[20]=this.juego.jButton471;
        Muestra[21]=this.juego.jButton472;
        Muestra[22]=this.juego.jButton477;
        Muestra[23]=this.juego.jButton478;
        Muestra[24]=this.juego.jButton479;
        Muestra[25]=this.juego.jButton480;
        Muestra[26]=this.juego.jButton481;
        Muestra[27]=this.juego.jButton482;
        Muestra[28]=this.juego.jButton483;
        Muestra[29]=this.juego.jButton484;
    }

    public void Declarar_BotonBase(){
        BotonBase = new JButton [225];
        
        BotonBase[0]=this.juego.jButton1;
        BotonBase[1]=this.juego.jButton2;
        BotonBase[2]=this.juego.jButton3;
        BotonBase[3]=this.juego.jButton4;
        BotonBase[4]=this.juego.jButton5;
        BotonBase[5]=this.juego.jButton6;
        BotonBase[6]=this.juego.jButton7;
        BotonBase[7]=this.juego.jButton8;
        BotonBase[8]=this.juego.jButton9;
        BotonBase[9]=this.juego.jButton10;
        BotonBase[10]=this.juego.jButton11;
        BotonBase[11]=this.juego.jButton12;
        BotonBase[12]=this.juego.jButton13;
        BotonBase[13]=this.juego.jButton14;
        BotonBase[14]=this.juego.jButton15;
        BotonBase[15]=this.juego.jButton16;
        BotonBase[16]=this.juego.jButton17;
        BotonBase[17]=this.juego.jButton18;
        BotonBase[18]=this.juego.jButton19;
        BotonBase[19]=this.juego.jButton20;
        BotonBase[20]=this.juego.jButton21;
        BotonBase[21]=this.juego.jButton22;
        BotonBase[22]=this.juego.jButton23;
        BotonBase[23]=this.juego.jButton24;
        BotonBase[24]=this.juego.jButton25;
        BotonBase[25]=this.juego.jButton26;
        BotonBase[26]=this.juego.jButton27;
        BotonBase[27]=this.juego.jButton28;
        BotonBase[28]=this.juego.jButton29;
        BotonBase[29]=this.juego.jButton30;
        BotonBase[30]=this.juego.jButton31;
        BotonBase[31]=this.juego.jButton32;
        BotonBase[32]=this.juego.jButton33;
        BotonBase[33]=this.juego.jButton34;
        BotonBase[34]=this.juego.jButton35;
        BotonBase[35]=this.juego.jButton36;
        BotonBase[36]=this.juego.jButton37;
        BotonBase[37]=this.juego.jButton38;
        BotonBase[38]=this.juego.jButton39;
        BotonBase[39]=this.juego.jButton40;
        BotonBase[40]=this.juego.jButton41;
        BotonBase[41]=this.juego.jButton42;
        BotonBase[42]=this.juego.jButton43;
        BotonBase[43]=this.juego.jButton44;
        BotonBase[44]=this.juego.jButton45;
        BotonBase[45]=this.juego.jButton46;
        BotonBase[46]=this.juego.jButton47;
        BotonBase[47]=this.juego.jButton48;
        BotonBase[48]=this.juego.jButton49;
        BotonBase[49]=this.juego.jButton50;
        BotonBase[50]=this.juego.jButton51;
        BotonBase[51]=this.juego.jButton52;
        BotonBase[52]=this.juego.jButton53;
        BotonBase[53]=this.juego.jButton54;
        BotonBase[54]=this.juego.jButton55;
        BotonBase[55]=this.juego.jButton56;
        BotonBase[56]=this.juego.jButton57;
        BotonBase[57]=this.juego.jButton58;
        BotonBase[58]=this.juego.jButton59;
        BotonBase[59]=this.juego.jButton60;
        BotonBase[60]=this.juego.jButton61;
        BotonBase[61]=this.juego.jButton62;
        BotonBase[62]=this.juego.jButton63;
        BotonBase[63]=this.juego.jButton64;
        BotonBase[64]=this.juego.jButton65;
        BotonBase[65]=this.juego.jButton66;
        BotonBase[66]=this.juego.jButton67;
        BotonBase[67]=this.juego.jButton68;
        BotonBase[68]=this.juego.jButton69;
        BotonBase[69]=this.juego.jButton70;
        BotonBase[70]=this.juego.jButton71;
        BotonBase[71]=this.juego.jButton72;
        BotonBase[72]=this.juego.jButton73;
        BotonBase[73]=this.juego.jButton74;
        BotonBase[74]=this.juego.jButton75;
        BotonBase[75]=this.juego.jButton76;
        BotonBase[76]=this.juego.jButton77;
        BotonBase[77]=this.juego.jButton78;
        BotonBase[78]=this.juego.jButton79;
        BotonBase[79]=this.juego.jButton80;
        BotonBase[80]=this.juego.jButton81;
        BotonBase[81]=this.juego.jButton82;
        BotonBase[82]=this.juego.jButton83;
        BotonBase[83]=this.juego.jButton84;
        BotonBase[84]=this.juego.jButton85;
        BotonBase[85]=this.juego.jButton86;
        BotonBase[86]=this.juego.jButton87;
        BotonBase[87]=this.juego.jButton88;
        BotonBase[88]=this.juego.jButton89;
        BotonBase[89]=this.juego.jButton90;
        BotonBase[90]=this.juego.jButton91;
        BotonBase[91]=this.juego.jButton92;
        BotonBase[92]=this.juego.jButton93;
        BotonBase[93]=this.juego.jButton94;
        BotonBase[94]=this.juego.jButton95;
        BotonBase[95]=this.juego.jButton96;
        BotonBase[96]=this.juego.jButton97;
        BotonBase[97]=this.juego.jButton98;
        BotonBase[98]=this.juego.jButton99;        
        BotonBase[99]=this.juego.jButton100;
        BotonBase[100]=this.juego.jButton101;
        BotonBase[101]=this.juego.jButton102;
        BotonBase[102]=this.juego.jButton103;
        BotonBase[103]=this.juego.jButton104;
        BotonBase[104]=this.juego.jButton105;
        BotonBase[105]=this.juego.jButton106;
        BotonBase[106]=this.juego.jButton107;
        BotonBase[107]=this.juego.jButton108;
        BotonBase[108]=this.juego.jButton109;
        BotonBase[109]=this.juego.jButton110;
        BotonBase[110]=this.juego.jButton111;
        BotonBase[111]=this.juego.jButton112;
        BotonBase[112]=this.juego.jButton113;
        BotonBase[113]=this.juego.jButton114;
        BotonBase[114]=this.juego.jButton115;
        BotonBase[115]=this.juego.jButton116;
        BotonBase[116]=this.juego.jButton117;
        BotonBase[117]=this.juego.jButton118;
        BotonBase[118]=this.juego.jButton119;
        BotonBase[119]=this.juego.jButton120;
        BotonBase[120]=this.juego.jButton121;
        BotonBase[121]=this.juego.jButton122;
        BotonBase[122]=this.juego.jButton123;
        BotonBase[123]=this.juego.jButton124;
        BotonBase[124]=this.juego.jButton125;
        BotonBase[125]=this.juego.jButton126;
        BotonBase[126]=this.juego.jButton127;
        BotonBase[127]=this.juego.jButton128;
        BotonBase[128]=this.juego.jButton129;
        BotonBase[129]=this.juego.jButton130;
        BotonBase[130]=this.juego.jButton131;
        BotonBase[131]=this.juego.jButton132;
        BotonBase[132]=this.juego.jButton133;
        BotonBase[133]=this.juego.jButton134;
        BotonBase[134]=this.juego.jButton135;
        BotonBase[135]=this.juego.jButton136;
        BotonBase[136]=this.juego.jButton137;
        BotonBase[137]=this.juego.jButton138;
        BotonBase[138]=this.juego.jButton139;
        BotonBase[139]=this.juego.jButton140;
        BotonBase[140]=this.juego.jButton141;
        BotonBase[141]=this.juego.jButton142;
        BotonBase[142]=this.juego.jButton143;
        BotonBase[143]=this.juego.jButton144;
        BotonBase[144]=this.juego.jButton145;
        BotonBase[145]=this.juego.jButton146;
        BotonBase[146]=this.juego.jButton147;
        BotonBase[147]=this.juego.jButton148;
        BotonBase[148]=this.juego.jButton149;
        BotonBase[149]=this.juego.jButton150;
        BotonBase[150]=this.juego.jButton151;
        BotonBase[151]=this.juego.jButton152;
        BotonBase[152]=this.juego.jButton153;
        BotonBase[153]=this.juego.jButton154;
        BotonBase[154]=this.juego.jButton155;
        BotonBase[155]=this.juego.jButton156;
        BotonBase[156]=this.juego.jButton157;
        BotonBase[157]=this.juego.jButton158;
        BotonBase[158]=this.juego.jButton159;
        BotonBase[159]=this.juego.jButton160;
        BotonBase[160]=this.juego.jButton161;
        BotonBase[161]=this.juego.jButton162;
        BotonBase[162]=this.juego.jButton163;
        BotonBase[163]=this.juego.jButton164;
        BotonBase[164]=this.juego.jButton165;
        BotonBase[165]=this.juego.jButton166;
        BotonBase[166]=this.juego.jButton167;
        BotonBase[167]=this.juego.jButton168;
        BotonBase[168]=this.juego.jButton169;
        BotonBase[169]=this.juego.jButton170;
        BotonBase[170]=this.juego.jButton171;
        BotonBase[171]=this.juego.jButton172;
        BotonBase[172]=this.juego.jButton173;
        BotonBase[173]=this.juego.jButton174;
        BotonBase[174]=this.juego.jButton175;
        BotonBase[175]=this.juego.jButton176;
        BotonBase[176]=this.juego.jButton177;
        BotonBase[177]=this.juego.jButton178;
        BotonBase[178]=this.juego.jButton179;
        BotonBase[179]=this.juego.jButton180;
        BotonBase[180]=this.juego.jButton181;
        BotonBase[181]=this.juego.jButton182;
        BotonBase[182]=this.juego.jButton183;
        BotonBase[183]=this.juego.jButton184;
        BotonBase[184]=this.juego.jButton185;
        BotonBase[185]=this.juego.jButton186;
        BotonBase[186]=this.juego.jButton187;
        BotonBase[187]=this.juego.jButton188;
        BotonBase[188]=this.juego.jButton189;
        BotonBase[189]=this.juego.jButton190;
        BotonBase[190]=this.juego.jButton191;
        BotonBase[191]=this.juego.jButton192;
        BotonBase[192]=this.juego.jButton193;
        BotonBase[193]=this.juego.jButton194;
        BotonBase[194]=this.juego.jButton195;
        BotonBase[195]=this.juego.jButton196;
        BotonBase[196]=this.juego.jButton197;
        BotonBase[197]=this.juego.jButton198;
        BotonBase[198]=this.juego.jButton199;
        BotonBase[199]=this.juego.jButton200;
        BotonBase[200]=this.juego.jButton201;
        BotonBase[201]=this.juego.jButton202;
        BotonBase[202]=this.juego.jButton203;
        BotonBase[203]=this.juego.jButton204;
        BotonBase[204]=this.juego.jButton205;
        BotonBase[205]=this.juego.jButton206;
        BotonBase[206]=this.juego.jButton207;
        BotonBase[207]=this.juego.jButton208;
        BotonBase[208]=this.juego.jButton209;
        BotonBase[209]=this.juego.jButton210;
        BotonBase[210]=this.juego.jButton211;
        BotonBase[211]=this.juego.jButton212;
        BotonBase[212]=this.juego.jButton213;
        BotonBase[213]=this.juego.jButton214;
        BotonBase[214]=this.juego.jButton215;
        BotonBase[215]=this.juego.jButton216;
        BotonBase[216]=this.juego.jButton217;
        BotonBase[217]=this.juego.jButton218;
        BotonBase[218]=this.juego.jButton219;
        BotonBase[219]=this.juego.jButton220;
        BotonBase[220]=this.juego.jButton221;
        BotonBase[221]=this.juego.jButton222;
        BotonBase[222]=this.juego.jButton223;
        BotonBase[223]=this.juego.jButton224;
        BotonBase[224]=this.juego.jButton225;
    }
    
    public void Declarar_BotonMapa(){
        BotonMapa=new JButton[225];
        
        BotonMapa[0]=this.juego.jButton226;
        BotonMapa[1]=this.juego.jButton227;
        BotonMapa[2]=this.juego.jButton228;
        BotonMapa[3]=this.juego.jButton229;
        BotonMapa[4]=this.juego.jButton230;
        BotonMapa[5]=this.juego.jButton231;
        BotonMapa[6]=this.juego.jButton232;
        BotonMapa[7]=this.juego.jButton233;
        BotonMapa[8]=this.juego.jButton234;
        BotonMapa[9]=this.juego.jButton235;
        BotonMapa[10]=this.juego.jButton236;
        BotonMapa[11]=this.juego.jButton237;
        BotonMapa[12]=this.juego.jButton238;
        BotonMapa[13]=this.juego.jButton239;
        BotonMapa[14]=this.juego.jButton240;
        BotonMapa[15]=this.juego.jButton241;
        BotonMapa[16]=this.juego.jButton242;
        BotonMapa[17]=this.juego.jButton243;
        BotonMapa[18]=this.juego.jButton244;
        BotonMapa[19]=this.juego.jButton245;
        BotonMapa[20]=this.juego.jButton246;
        BotonMapa[21]=this.juego.jButton247;
        BotonMapa[22]=this.juego.jButton248;
        BotonMapa[23]=this.juego.jButton249;
        BotonMapa[24]=this.juego.jButton250;
        BotonMapa[25]=this.juego.jButton251;
        BotonMapa[26]=this.juego.jButton252;
        BotonMapa[27]=this.juego.jButton253;
        BotonMapa[28]=this.juego.jButton254;
        BotonMapa[29]=this.juego.jButton255;
        BotonMapa[30]=this.juego.jButton256;
        BotonMapa[31]=this.juego.jButton257;
        BotonMapa[32]=this.juego.jButton258;
        BotonMapa[33]=this.juego.jButton259;
        BotonMapa[34]=this.juego.jButton260;
        BotonMapa[35]=this.juego.jButton261;
        BotonMapa[36]=this.juego.jButton262;
        BotonMapa[37]=this.juego.jButton263;
        BotonMapa[38]=this.juego.jButton264;
        BotonMapa[39]=this.juego.jButton265;
        BotonMapa[40]=this.juego.jButton266;
        BotonMapa[41]=this.juego.jButton267;
        BotonMapa[42]=this.juego.jButton268;
        BotonMapa[43]=this.juego.jButton269;
        BotonMapa[44]=this.juego.jButton270;
        BotonMapa[45]=this.juego.jButton271;
        BotonMapa[46]=this.juego.jButton272;
        BotonMapa[47]=this.juego.jButton273;
        BotonMapa[48]=this.juego.jButton274;
        BotonMapa[49]=this.juego.jButton275;
        BotonMapa[50]=this.juego.jButton276;
        BotonMapa[51]=this.juego.jButton277;
        BotonMapa[52]=this.juego.jButton278;
        BotonMapa[53]=this.juego.jButton279;
        BotonMapa[54]=this.juego.jButton280;
        BotonMapa[55]=this.juego.jButton281;
        BotonMapa[56]=this.juego.jButton282;
        BotonMapa[57]=this.juego.jButton283;
        BotonMapa[58]=this.juego.jButton284;
        BotonMapa[59]=this.juego.jButton285;
        BotonMapa[60]=this.juego.jButton286;
        BotonMapa[61]=this.juego.jButton287;
        BotonMapa[62]=this.juego.jButton288;
        BotonMapa[63]=this.juego.jButton289;
        BotonMapa[64]=this.juego.jButton290;
        BotonMapa[65]=this.juego.jButton291;
        BotonMapa[66]=this.juego.jButton292;
        BotonMapa[67]=this.juego.jButton293;
        BotonMapa[68]=this.juego.jButton294;
        BotonMapa[69]=this.juego.jButton295;
        BotonMapa[70]=this.juego.jButton296;
        BotonMapa[71]=this.juego.jButton297;
        BotonMapa[72]=this.juego.jButton298;
        BotonMapa[73]=this.juego.jButton299;
        BotonMapa[74]=this.juego.jButton300;
        BotonMapa[75]=this.juego.jButton301;
        BotonMapa[76]=this.juego.jButton302;
        BotonMapa[77]=this.juego.jButton303;
        BotonMapa[78]=this.juego.jButton304;
        BotonMapa[79]=this.juego.jButton305;
        BotonMapa[80]=this.juego.jButton306;
        BotonMapa[81]=this.juego.jButton307;
        BotonMapa[82]=this.juego.jButton308;
        BotonMapa[83]=this.juego.jButton309;
        BotonMapa[84]=this.juego.jButton310;
        BotonMapa[85]=this.juego.jButton311;
        BotonMapa[86]=this.juego.jButton312;
        BotonMapa[87]=this.juego.jButton313;
        BotonMapa[88]=this.juego.jButton314;
        BotonMapa[89]=this.juego.jButton315;
        BotonMapa[90]=this.juego.jButton316;
        BotonMapa[91]=this.juego.jButton317;
        BotonMapa[92]=this.juego.jButton318;
        BotonMapa[93]=this.juego.jButton319;
        BotonMapa[94]=this.juego.jButton320;
        BotonMapa[95]=this.juego.jButton321;
        BotonMapa[96]=this.juego.jButton322;
        BotonMapa[97]=this.juego.jButton323;
        BotonMapa[98]=this.juego.jButton324;       
        BotonMapa[99]=this.juego.jButton325;
        BotonMapa[100]=this.juego.jButton326;
        BotonMapa[101]=this.juego.jButton327;
        BotonMapa[102]=this.juego.jButton328;
        BotonMapa[103]=this.juego.jButton329;
        BotonMapa[104]=this.juego.jButton330;
        BotonMapa[105]=this.juego.jButton331;
        BotonMapa[106]=this.juego.jButton332;
        BotonMapa[107]=this.juego.jButton333;
        BotonMapa[108]=this.juego.jButton334;
        BotonMapa[109]=this.juego.jButton335;
        BotonMapa[110]=this.juego.jButton336;
        BotonMapa[111]=this.juego.jButton337;
        BotonMapa[112]=this.juego.jButton338;
        BotonMapa[113]=this.juego.jButton339;
        BotonMapa[114]=this.juego.jButton340;
        BotonMapa[115]=this.juego.jButton341;
        BotonMapa[116]=this.juego.jButton342;
        BotonMapa[117]=this.juego.jButton343;
        BotonMapa[118]=this.juego.jButton344;
        BotonMapa[119]=this.juego.jButton345;
        BotonMapa[120]=this.juego.jButton346;
        BotonMapa[121]=this.juego.jButton347;
        BotonMapa[122]=this.juego.jButton348;
        BotonMapa[123]=this.juego.jButton349;
        BotonMapa[124]=this.juego.jButton350;
        BotonMapa[125]=this.juego.jButton351;
        BotonMapa[126]=this.juego.jButton352;
        BotonMapa[127]=this.juego.jButton353;
        BotonMapa[128]=this.juego.jButton354;
        BotonMapa[129]=this.juego.jButton355;
        BotonMapa[130]=this.juego.jButton356;
        BotonMapa[131]=this.juego.jButton357;
        BotonMapa[132]=this.juego.jButton358;
        BotonMapa[133]=this.juego.jButton359;
        BotonMapa[134]=this.juego.jButton360;
        BotonMapa[135]=this.juego.jButton361;
        BotonMapa[136]=this.juego.jButton362;
        BotonMapa[137]=this.juego.jButton363;
        BotonMapa[138]=this.juego.jButton364;
        BotonMapa[139]=this.juego.jButton365;
        BotonMapa[140]=this.juego.jButton366;
        BotonMapa[141]=this.juego.jButton367;
        BotonMapa[142]=this.juego.jButton368;
        BotonMapa[143]=this.juego.jButton369;
        BotonMapa[144]=this.juego.jButton370;
        BotonMapa[145]=this.juego.jButton371;
        BotonMapa[146]=this.juego.jButton372;
        BotonMapa[147]=this.juego.jButton373;
        BotonMapa[148]=this.juego.jButton374;
        BotonMapa[149]=this.juego.jButton375;
        BotonMapa[150]=this.juego.jButton376;
        BotonMapa[151]=this.juego.jButton377;
        BotonMapa[152]=this.juego.jButton378;
        BotonMapa[153]=this.juego.jButton379;
        BotonMapa[154]=this.juego.jButton380;
        BotonMapa[155]=this.juego.jButton381;
        BotonMapa[156]=this.juego.jButton382;
        BotonMapa[157]=this.juego.jButton383;
        BotonMapa[158]=this.juego.jButton384;
        BotonMapa[159]=this.juego.jButton385;
        BotonMapa[160]=this.juego.jButton386;
        BotonMapa[161]=this.juego.jButton387;
        BotonMapa[162]=this.juego.jButton388;
        BotonMapa[163]=this.juego.jButton389;
        BotonMapa[164]=this.juego.jButton390;
        BotonMapa[165]=this.juego.jButton391;
        BotonMapa[166]=this.juego.jButton392;
        BotonMapa[167]=this.juego.jButton393;
        BotonMapa[168]=this.juego.jButton394;
        BotonMapa[169]=this.juego.jButton395;
        BotonMapa[170]=this.juego.jButton396;
        BotonMapa[171]=this.juego.jButton397;
        BotonMapa[172]=this.juego.jButton398;
        BotonMapa[173]=this.juego.jButton399;
        BotonMapa[174]=this.juego.jButton400;
        BotonMapa[175]=this.juego.jButton401;
        BotonMapa[176]=this.juego.jButton402;
        BotonMapa[177]=this.juego.jButton403;
        BotonMapa[178]=this.juego.jButton404;
        BotonMapa[179]=this.juego.jButton405;
        BotonMapa[180]=this.juego.jButton406;
        BotonMapa[181]=this.juego.jButton407;
        BotonMapa[182]=this.juego.jButton408;
        BotonMapa[183]=this.juego.jButton409;
        BotonMapa[184]=this.juego.jButton410;
        BotonMapa[185]=this.juego.jButton411;
        BotonMapa[186]=this.juego.jButton412;
        BotonMapa[187]=this.juego.jButton413;
        BotonMapa[188]=this.juego.jButton414;
        BotonMapa[189]=this.juego.jButton415;
        BotonMapa[190]=this.juego.jButton416;
        BotonMapa[191]=this.juego.jButton417;
        BotonMapa[192]=this.juego.jButton418;
        BotonMapa[193]=this.juego.jButton419;
        BotonMapa[194]=this.juego.jButton420;
        BotonMapa[195]=this.juego.jButton421;
        BotonMapa[196]=this.juego.jButton422;
        BotonMapa[197]=this.juego.jButton423;
        BotonMapa[198]=this.juego.jButton424;
        BotonMapa[199]=this.juego.jButton425;
        BotonMapa[200]=this.juego.jButton426;
        BotonMapa[201]=this.juego.jButton427;
        BotonMapa[202]=this.juego.jButton428;
        BotonMapa[203]=this.juego.jButton429;
        BotonMapa[204]=this.juego.jButton430;
        BotonMapa[205]=this.juego.jButton431;
        BotonMapa[206]=this.juego.jButton432;
        BotonMapa[207]=this.juego.jButton433;
        BotonMapa[208]=this.juego.jButton434;
        BotonMapa[209]=this.juego.jButton435;
        BotonMapa[210]=this.juego.jButton436;
        BotonMapa[211]=this.juego.jButton437;
        BotonMapa[212]=this.juego.jButton438;
        BotonMapa[213]=this.juego.jButton439;
        BotonMapa[214]=this.juego.jButton440;
        BotonMapa[215]=this.juego.jButton441;
        BotonMapa[216]=this.juego.jButton442;
        BotonMapa[217]=this.juego.jButton443;
        BotonMapa[218]=this.juego.jButton444;
        BotonMapa[219]=this.juego.jButton445;
        BotonMapa[220]=this.juego.jButton446;
        BotonMapa[221]=this.juego.jButton447;
        BotonMapa[222]=this.juego.jButton448;
        BotonMapa[223]=this.juego.jButton449;
        BotonMapa[224]=this.juego.jButton450;
    }

}
