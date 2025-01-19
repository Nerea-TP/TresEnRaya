package motor3R;

/**
 * Tres en Raya va a contener la lógica del juego, sólo se jugara un modo Humano
 * vs Máquina
 * 
 * @author Nerea Trillo Pérez
 * 
 * @version v1.6
 * 
 * @since 12/02/2023
 */
public class TresEnRaya {
    private char[][] tablero = new char[3][3];

    /**
     * Método que devuelve le tablero existente en la clase
     * 
     * @return tablero
     */
    public char[][] getTablero() {
        return tablero;
    }

    /**
     * crea un tablero 3x3 vacío y lo rellena con el símbolo "-"
     */
    public TresEnRaya() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    /**
     * Recorre el tablero entero comprobando si en cada posición hay una celda vacía
     * 
     * @return true si el tablero está lleno, false si no está lleno y tiene alguna
     *         celda vacía
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == '-') {// si la celda tiene "-" está vacía
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Marca la casilla escogida por el Jugador con una "X"
     * 
     * @param fila    Número entero de la fila del tablero.
     * @param columna Número entero de la columna del tablero.
     * @return resultado. Devuleve falso si la casilla está ocupada, sino marca
     *         casilla
     */
    public boolean turnoJugador(int fila, int columna) {
        boolean resultado = true;
        // si en la fila y columna hay "X" o "O" falso, sino marco casilla
        if (tablero[fila - 1][columna - 1] == 'X' || tablero[fila - 1][columna - 1] == 'O') {
            resultado = false;
        } else {
            if (tablero[fila - 1][columna - 1] == '-') {
                tablero[fila - 1][columna - 1] = 'X';
            }
        }
        return resultado;
    }

    /**
     * Marca la casilla escogida, aleatoriamente por la máquina, con una "O"
     */
    public void turnoMaquina() {
        /*
         * para generar números aleatorios comprendidos entre 2 rangos usamos
         * la ecuación (X-Y+1)+Y;donde X es el límite superior e Y el inferior
         */
        while (true) {
            int fila = (int) (Math.random() * (3 - 1 + 1) + 1);
            int columna = (int) (Math.random() * (3 - 1 + 1) + 1);
            if (tablero[fila - 1][columna - 1] == '-') {
                tablero[fila - 1][columna - 1] = 'O';
                break;
            }
        }
    }

    /**
     * Comprueba quien ha hecho tres en raya en horizontal, vertical o diagonal
     * 
     * @param quienJuega recibe el valor char de quien juega (Jugador-"X" o
     *                   Máquina-"O")
     * @return true si se ha hecho tres en raya, false si no se hizo
     */

    public boolean ganador(char quienJuega) {
        // se comprueba por filas
        if (tablero[0][0] == quienJuega && tablero[0][1] == quienJuega && tablero[0][2] == quienJuega) {
            return true;
        } else if (tablero[1][0] == quienJuega && tablero[1][1] == quienJuega && tablero[1][2] == quienJuega) {
            return true;
        } else if (tablero[2][0] == quienJuega && tablero[2][1] == quienJuega && tablero[2][2] == quienJuega) {
            return true;
        }
        // se comprueba columnas
        else if (tablero[0][0] == quienJuega && tablero[1][0] == quienJuega && tablero[2][0] == quienJuega) {
            return true;
        } else if (tablero[0][1] == quienJuega && tablero[1][1] == quienJuega && tablero[2][1] == quienJuega) {
            return true;
        } else if (tablero[0][2] == quienJuega && tablero[1][2] == quienJuega && tablero[2][2] == quienJuega) {
            return true;
            // se comprueba diagonales
        } else if (tablero[0][0] == quienJuega && tablero[1][1] == quienJuega && tablero[2][2] == quienJuega) {
            return true;
        } else if (tablero[2][0] == quienJuega && tablero[1][1] == quienJuega && tablero[0][2] == quienJuega) {
            return true;
        } else {
            return false;
        }
    }
}
