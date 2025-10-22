package holaproceso;

import java.io.IOException;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu nombre: ");
        String name = sc.nextLine();

        String path = "holaproceso.App2";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"), path, name);
        try {
            pb.inheritIO();
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
