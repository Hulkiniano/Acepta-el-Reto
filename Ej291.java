/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AceptaElReto;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author hulkiniano
 */
public class Ej291 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            n = Integer.parseInt(sc.nextLine());
            if (n != 0) {
                entrada(n, sc);
            }
        } while (n != 0);

    }

    public static void entrada(int n, Scanner sc) {
        TreeMap<String, TreeSet<Integer>> l = new TreeMap<String, TreeSet<Integer>>();
        int fila = 0;
        for (int i = 0; i < n; i++) {
            String frase = sc.nextLine().toLowerCase();
            String[] palabras = frase.split(" ");
            fila++;
            insertar(l, palabras, fila);
        }
        salida(l);
    }

    public static void insertar(TreeMap<String, TreeSet<Integer>> l, String[] palabras, int fila) {
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() > 2) {
                validar(l, fila, palabras[i]);
            }
        }
    }

    public static void validar(TreeMap<String, TreeSet<Integer>> l, int fila, String palabra) {
        if (!l.containsKey(palabra)) {
            l.put(palabra, new TreeSet<Integer>());
            l.get(palabra).add(fila);
        } else {
            l.get(palabra).add(fila);
        }

    }
    
    public static void salida(TreeMap<String, TreeSet<Integer>> l){
        for (Map.Entry<String, TreeSet<Integer>> entry : l.entrySet()) {
                System.out.print(entry.getKey());
                for (Integer n : entry.getValue()) {
                    System.out.print(" " + n);
                }
                System.out.println();
            }
        System.out.println("----");
    }
}
