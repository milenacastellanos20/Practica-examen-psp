package ecoconargumentos2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class App1 {
    public static void main(String[] args) {

        StringBuilder cadena = crearCadena(args);
        StringBuilder resultado = revertir(cadena);
        System.out.println(resultado);
    }

    private static StringBuilder revertir(StringBuilder cadena) {
        String[] alreves = cadena.toString().trim().split(" ");
        StringBuilder resultado = new StringBuilder();
        for (int i = alreves.length; i > 0; i--) {
            resultado.append(alreves[i - 1]);
            if (i != 0) {
                resultado.append(" ");
            }
        }
        return resultado;
    }

    private static StringBuilder crearCadena(String[] args) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            cadena.append(args[i]);
            if (i != args.length - 1) {
                cadena.append(" ");
            }
        }
        return cadena;
    }
}
