package juegocartas;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;

public class Jugador {

    public int TOTAL_CARTAS = 10;

    private Carta[] cartas;

    public void repartir() {
        cartas = new Carta[TOTAL_CARTAS];
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta();
        }
        /*cartas[0] = new Carta(3);
        cartas[1] = new Carta(6);
        cartas[2] = new Carta(11);
        cartas[3] = new Carta(12);
        cartas[4] = new Carta(13);
        cartas[5] = new Carta(21);
        cartas[6] = new Carta(39);
        cartas[7] = new Carta(47);
        cartas[8] = new Carta(39);
        cartas[9] = new Carta(50);*/
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i].mostrar(pnl, 5 + i * 40, 5);
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No hay grupos";

        int[] contadores = new int[NombreCarta.values().length];

        for (int i = 0; i < cartas.length; i++) {
            contadores[cartas[i].getNombre().ordinal()]++;
        }

        int totalGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                totalGrupos++;
            }
        }
        if (totalGrupos > 0) {
            mensaje = "Los grupos encontrados fueron:\n";
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] >= 2) {
                    mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                }
            }
        }
        return mensaje;
    }

    String getEscaleras() {
        Arrays.sort(cartas);
        System.out.println("Cartas antes de ordenar:");
        Arrays.stream(cartas).forEach(carta -> System.out.println(carta));
        String mensaje = "";
        int contEscalera = 1;        
        Pinta tipoEscalera = null;
        for (int c = 1; c < cartas.length; c++) {
            if ((cartas[c].getIndice() == cartas[c - 1].getIndice() + 1) && cartas[c].getPinta() == cartas[c - 1].getPinta()) {
                contEscalera++;
                tipoEscalera = cartas[c].getPinta();
            } else {
                if (contEscalera > 1) {
                    mensaje += String.format("Se ha encontrado la escalera: %s de %s\n", Grupo.values()[contEscalera], tipoEscalera);
                }
                contEscalera = 1;
            }
        }
        if (contEscalera > 1) {
            mensaje += String.format("Se ha encontrado la escalera: %s de %s\n", Grupo.values()[contEscalera], tipoEscalera);
        }

        if (tipoEscalera == null) {
            mensaje = "No hay escaleras";
        }

        return mensaje;
    }

    public String getPuntaje() {
        boolean[] usadas = new boolean[cartas.length];
        int contEscalera = 1;
        int conteoNoUsadas = cartas.length;
        for (int c = 1; c < cartas.length; c++) {
            usadas[c] = false;
            if ((cartas[c].getIndice() == cartas[c - 1].getIndice() + 1) && cartas[c].getPinta() == cartas[c - 1].getPinta()) {
                contEscalera++;
                usadas[c] = true;
                usadas[c - 1] = true;
            } else {
                contEscalera = 1;
            }
        }
        for (boolean usada : usadas) {
            if (usada) {
                conteoNoUsadas--;
            }
        }        
        Carta[] cartasNoUsadas = new Carta[conteoNoUsadas];
        int n = 0;
        for (int c = 0; c < cartas.length; c++) {
            if (!usadas[c]) {
                cartasNoUsadas[n] = cartas[c];
                n++;
            }
        }
        ///Arrays.stream(cartasNoUsadas).forEach(carta -> System.out.println(carta));
        //Conteo por agrupracion de las cartas no usadas
        int[] contadores = new int[NombreCarta.values().length];
        boolean[] usadasEnGrupos = new boolean[cartasNoUsadas.length];

        for (int i = 0; i < cartasNoUsadas.length; i++) {
            contadores[cartasNoUsadas[i].getNombre().ordinal()]++;
        }

        int totalPuntaje = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == 1)                            
                totalPuntaje += new Carta(i+1).getValor();
        }
        return "Puntaje: " + totalPuntaje;
    }
}
