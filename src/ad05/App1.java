package ad05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App1 {
    public static void main(String[] args) {
        int numCaracteres = 0;
        int numLinea = 0;
        boolean java = false;
        Map<Character, Integer> contadorVocales = new HashMap<>();
        contadorVocales.put('a', 0);
        contadorVocales.put('e', 0);
        contadorVocales.put('i', 0);
        contadorVocales.put('o', 0);
        contadorVocales.put('u', 0);

        try {
            BufferedReader br = new BufferedReader(new FileReader("palabras.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!(linea.isEmpty())) {
                    numLinea++;
                    numCaracteres = linea.length();
                }
                for (char c : linea.toCharArray()) {
                    if (contadorVocales.containsKey(c)) {
                        contadorVocales.put(c, contadorVocales.get(c) + 1);
                    }
                }
                if (linea.contains("java")) {
                    java = true;
                }
            }
            System.out.println("El fichero tiene " + numLinea + " lineas");
            System.out.println("El fichero tiene " + numCaracteres + " caracteres");
            if (java) {
                System.out.println("El fichero tiene java");
            } else {
                System.out.println("El fichero no tiene java");
            }
            char vocalMasFrecuente = encontrarVocalMasFrecuente(contadorVocales);
            int frecuencia = contadorVocales.get(vocalMasFrecuente);
            System.out.println("Vocal que más aparece: '" + vocalMasFrecuente + "' (" + frecuencia + " veces)");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static char encontrarVocalMasFrecuente(Map<Character, Integer> contadorVocales) {
        char vocalMax = 'a';
        int maxFrecuencia = 0;

        for (Map.Entry<Character, Integer> entry : contadorVocales.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                vocalMax = entry.getKey();
            }
        }
        return vocalMax;
    }
}
