package sumaporargumentos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("numero: ");
        int num1 = sc.nextInt();
        System.out.println("numero: ");
        int num2 = sc.nextInt();

        String path = "sumaporargumentos.App1";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path, Integer.toString(num1), Integer.toString(num2));
        try {
            pb.inheritIO();
            Process p = pb.start();
            /*
            TAMBIEN SE PUEDE USAR ESTO

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
