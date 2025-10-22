package ecoconargumentos;

import java.util.ArrayList;
import java.util.Collections;

public class App1 {
    public static void main(String[] args) {
        StringBuilder recibida = new StringBuilder();
        for (String palabra : args) {
            recibida.append(palabra);
        }
        System.out.println(recibida.reverse().toString());//invierte caracter por caracter
    }
}
