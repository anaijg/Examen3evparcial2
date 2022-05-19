package ejercicio2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Llamamos al primer metodo: ");
            //crearFicheroBinarioCadenas();
        System.out.println("Llamamos al segundo metodo: ");
            //crearFicheroBinarioNumeros();
            System.out.println("Leyendo ficheros...");
            //leerFicheros();
    }

    private static void leerFicheros() {
        System.out.println("Contenido del fichero de cadenas de texto:");
        try (ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("src\\main\\java\\ejercicio2\\cadenas.dat"));
        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("src\\main\\java\\ejercicio2\\numeros.dat"))) {
            String[] contenido = (String[]) in1.readObject();
            System.out.println(Arrays.toString(contenido));
            System.out.println("Contenido del fichero de numeros: ");
            while (true) {
                int numero =  in2.readInt();
                System.out.print(numero + " ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException eofException) {
            System.out.println("\nFIN");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void crearFicheroBinarioNumeros() {
        System.out.println("Cantidad de numeros a introducir: ");
        int n = sc.nextInt();
        sc.nextLine();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\ejercicio2\\numeros.dat"))) {
            for (int i = 0; i < n; i++) {
                System.out.println("Numero:");
                out.writeInt(sc.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void crearFicheroBinarioCadenas() {
        System.out.println("Numero de cadenas a introducir: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] cadenas = new String[n];
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\ejercicio2\\cadenas.dat"))) {
            for (int i = 0; i < n; i++) {
                System.out.println("Introducir cadena: ");
                cadenas[i] = sc.nextLine();
            }
            out.writeObject(cadenas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
