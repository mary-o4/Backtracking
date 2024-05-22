import Ejercicio2.Celda;
import Ejercicio2.Laberinto;

public class Main {
    public static void main(String[] args) {
        Celda[][] laberinto = {
                { new Celda(1, false, true, true, false), new Celda(2, false, false, true, true) },
                { new Celda(3, true, true, false, false), new Celda(4, true, false, false, true) }
        };

        Laberinto l = new Laberinto(laberinto);
        int longitudMinima = l.encontrarCaminoMinimo(0, 0, 1, 1);
        System.out.println("Longitud mínima del camino: " + longitudMinima);
    }

}
