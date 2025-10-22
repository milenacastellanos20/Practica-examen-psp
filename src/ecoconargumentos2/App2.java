package ecoconargumentos2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        String path = "ecoconargumentos2.App1";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path, frase.trim());
        try {
            Process p = pb.start();
            p.waitFor();

            BufferedReader recibida = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = recibida.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
