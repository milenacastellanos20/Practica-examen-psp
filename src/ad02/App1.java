package ad02;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class App1 {
    public static void main(String[] args) {
        Random rand = new Random();
        String nombreFichero = "milena.txt";

        int aleatorio = rand.nextInt(100 - 1 + 1) + 1;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
            for (int i = 0; i < aleatorio; i++) {
                int numero = rand.nextInt(100 - 1 + 1) + 1;
                bw.write(numero + " ");
            }
            bw.close();
            infoEnteros(nombreFichero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void infoEnteros(String nombreFichero){
        int mayor = MIN_VALUE;
        int menor = MAX_VALUE;
        int total = 0;
        double media;
        double suma = 0;
        int cantidadMayoresNacimiento = 0;
        ArrayList<Integer> numeros = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            String linea;
            String[] numerosString;
            while((linea = br.readLine()) != null){
                numerosString = linea.split(" ");
                for (String numeroString : numerosString) {
                    numeros.add(Integer.parseInt(numeroString));
                }
            }
            br.close();

            for (int i = 0; i < numeros.size(); i++) {
                total++;
                suma += numeros.get(i);
                if (numeros.get(i) > mayor){
                    mayor = numeros.get(i);
                }
                if (numeros.get(i) < menor){
                    menor = numeros.get(i);
                }
                if (numeros.get(i) >= 22){
                    cantidadMayoresNacimiento++;
                }
            }
            media = suma/total;
            System.out.println("Mayor: " + mayor);
            System.out.println("Menor: " + menor);
            System.out.println("Total: " + total);
            System.out.println("Media: " + media);
            System.out.println("Mayores a la suma de mi cumpleaños: " + cantidadMayoresNacimiento);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
