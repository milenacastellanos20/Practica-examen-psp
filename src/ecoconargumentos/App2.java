package ecoconargumentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce una frase: ");
        String frase = input.nextLine();
        String path = "ecoconargumentos.App1";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path, frase.trim());
        try{
            Process p = pb.start();
            p.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
