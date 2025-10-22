package contadordelineas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del fichero: ");
        String fichero = sc.nextLine();
        String path = "contadordelineas.App1";

        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp",System.getProperty("java.class.path"), path, fichero);
            Process p = pb.start();
            p.waitFor();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
