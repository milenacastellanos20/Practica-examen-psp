package miniblockdenotas;

import java.io.*;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fichero = args[0];
        String frase;
        do {
            System.out.println("Introduce una frase");
            frase = sc.nextLine();
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
                if (!(frase.contains("fin"))){
                    bw.write(frase);
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!(frase.contains("fin")));
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String line;
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
