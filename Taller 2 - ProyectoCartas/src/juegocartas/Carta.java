package juegocartas;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta implements Comparable<Carta> {

    private int indice;
    private static Random r=new Random();

    public Carta() {
        indice = r.nextInt(52)+1;
    }
    public Carta(int indice){
        this.indice=indice;
    }
   
    public int getIndice(){
        return indice;
    }

    public Pinta getPinta() {
        if (indice <= 13) {
            return Pinta.TREBOL;
        } else if (indice <= 26) {
            return Pinta.PICA;
        } else if (indice <= 39) {
            return Pinta.CORAZON;
        } else {
            return Pinta.DIAMANTE;
        }
    }

    public NombreCarta getNombre() {
        int numero = indice % 13;
        if (numero == 0) {
            numero = 13;
        }
        return NombreCarta.values()[numero - 1];
    }

    public void mostrar(JPanel pnl, int x, int y) {
        String nombreImagen = "/imagenes/carta" + String.valueOf(indice) + ".jpg";

        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));
        JLabel lbl = new JLabel(imagen);
        lbl.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());

        pnl.add(lbl);

    }

    @Override
    public int compareTo(Carta cartaComp) {        
        if(this.indice>cartaComp.indice)
            return 1;
        if(this.indice==cartaComp.indice)
            return 0;
        if(this.indice<cartaComp.indice)
            return -1;
        return 0;
    }
    
    @Override
    public String toString(){        
        return "Carta: "+String.format("%-7s", this.getNombre())+
                "Indice: "+String.format("%-3s", this.indice)+
                "Pinta: "+String.format("%-9s", this.getPinta())+
                "Puntaje: "+String.format("%-9s", this.getValor());
    }

    int getValor() {
        int numero=indice%13;
        if(numero==0||numero==1||numero==11||numero==12)
            return 10;
        else
            return numero;
    }
}
