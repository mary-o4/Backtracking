package Ejercicio2;

import java.util.*;

public class Laberinto {
    private Celda[][] laberinto;
    private boolean[][] visitados;
    private int minLongitud;
    private int filas, columnas;

    public Laberinto(Celda[][] laberinto) {
        this.laberinto = laberinto;
        this.filas = laberinto.length;
        this.columnas = laberinto[0].length;
        this.visitados = new boolean[filas][columnas];
        this.minLongitud = Integer.MAX_VALUE;
    }

    public int encontrarCaminoMinimo(int origenX, int origenY, int destinoX, int destinoY) {
        backtrack(origenX, origenY, destinoX, destinoY, 0);
        return minLongitud;
    }

    private void backtrack(int x, int y, int destinoX, int destinoY, int longitudActual) {
        if (x == destinoX && y == destinoY) {
            if (longitudActual < minLongitud) {
                minLongitud = longitudActual;
            }
            return;
        }

        visitados[x][y] = true;

        // Norte
        if (laberinto[x][y].norte && x > 0 && !visitados[x - 1][y]) {
            backtrack(x - 1, y, destinoX, destinoY, longitudActual + laberinto[x - 1][y].valor);
        }

        // Este
        if (laberinto[x][y].este && y < columnas - 1 && !visitados[x][y + 1]) {
            backtrack(x, y + 1, destinoX, destinoY, longitudActual + laberinto[x][y + 1].valor);
        }

        // Sur
        if (laberinto[x][y].sur && x < filas - 1 && !visitados[x + 1][y]) {
            backtrack(x + 1, y, destinoX, destinoY, longitudActual + laberinto[x + 1][y].valor);
        }

        // Oeste
        if (laberinto[x][y].oeste && y > 0 && !visitados[x][y - 1]) {
            backtrack(x, y - 1, destinoX, destinoY, longitudActual + laberinto[x][y - 1].valor);
        }

        visitados[x][y] = false; // Backtracking
    }
}
