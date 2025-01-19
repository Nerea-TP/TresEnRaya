import java.util.Scanner;

import motor3R.TresEnRaya;

public class InterfaceConsola {
    Scanner sc = new Scanner(System.in);
    TresEnRaya tRaya;

    InterfaceConsola() {
        tRaya = new TresEnRaya();
        presentarJuego();
        mostrarTablero();
        partida();
    }

    public void presentarJuego() {
        System.out.println("\nEl juego consiste en poner X u O en las casillas y hacer 3 en raya");
        System.out.println("\nSe puede hacer 3 en raya: horizontalmente, vertcalmente o en diagonal");
        System.out.println("\nEl modo del juego será humano vs máquina");
        System.out.println("\nLa máquina juega con el caracter O");
        System.out.println("\nEL jugador juega con el caracter X");
        System.out.println("\nSiempre va a empezar el jugador");
        System.out.println("\nPrimeramente mostraremos el tablero vacío");
        System.out.println("\nLet's go!!!!");
    }

    // método que muestra el tablero
    private void mostrarTablero() {
        for (int i = 0; i < tRaya.getTablero().length; i++) {
            System.out.print("\t");
            for (int j = 0; j < tRaya.getTablero().length; j++) {
                System.out.print(" | " + tRaya.getTablero()[i][j]);
            }
            System.out.print(" | ");
            System.out.println("");
        }
    }

    // método que muestra la partida
    public void partida() {
        boolean resultado;
        // se repite hasta que haya ganador o empate
        do {
            System.out.println("\nEs el turno del jugador:");
            System.out.println("\tIndique la posición:");
            // pide fila y columna
            int fila = sc.nextInt();
            int columna = sc.nextInt();
            // mientras sea falso, está ocupando casilla, se repite pedir filas y columnas
            while (!tRaya.turnoJugador(fila, columna)) {
                System.out.println("\nERROR, CASILLA OCUPADA!!!\n\n Indique nueva posición:");
                fila = sc.nextInt();
                columna = sc.nextInt();
            }

            mostrarTablero();

            resultado = tRaya.ganador('X');
            if (resultado == true) {
                System.out.println("\nGANA JUGADOR");
                break;
            }
            resultado = tRaya.tableroLleno();
            if (resultado == true) {
                System.out.println("\nEMPATE");
                break;
            }
            System.out.println("\n\nEs el turno de la máquina:");
            System.out.println("\tPosición de la máquina aleatorio:");
            tRaya.turnoMaquina();
            mostrarTablero();
            resultado = tRaya.ganador('O');
            if (resultado == true) {
                System.out.println("\nGANA MAQUINA");
                break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        new InterfaceConsola();
    }

}
