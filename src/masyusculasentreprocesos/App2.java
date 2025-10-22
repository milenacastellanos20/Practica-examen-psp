package masyusculasentreprocesos;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String frase = sc.nextLine();
            if(frase.equals("fin")) break;
            System.out.println(frase.toUpperCase());
        }
        sc.close();
    }
}
