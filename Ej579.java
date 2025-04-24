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
public class Ej579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            n = Integer.parseInt(sc.nextLine());
            if (n != 0) {
                entrada(sc, n);
            }
        } while (n != 0);
    }
    
    public static void entrada(Scanner sc, int n) {
        ArrayList<Tarea> t = new ArrayList<Tarea>();
        for (int i = 0; i < n; i++) {
           int pri = Integer.parseInt(sc.next());
           int dur = Integer.parseInt(sc.next());
           String m = sc.nextLine();
           t.add(new Tarea(pri, dur));
        }
        salida(t);
    }
    
    public static void salida (ArrayList<Tarea> t) {
        Collections.sort(t, comp);
        for (Tarea tar : t) {
            System.out.println(tar.getPrioridad() + " " + tar.getDuracion());
        }
        System.out.println("---");
    }
    
    static Comparator comp = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Tarea t1 = (Tarea) o1;
            Tarea t2 = (Tarea) o2;
            if (t1.getPrioridad() == t2.getPrioridad()) {
                return t1.getDuracion() - t2.getDuracion();
            } else {
                return t2.getPrioridad() - t1.getPrioridad();
            }
        }
    };
    
        static class Tarea {
        private int prioridad;
        private int duracion;

       
        
        public Tarea(int prioridad, int duracion) {
            this.prioridad = prioridad;
            this.duracion = duracion;
        }
        
        public int getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(int prioridad) {
            this.prioridad = prioridad;
        }

        public int getDuracion() {
            return duracion;
        }

        public void setDuracion(int duracion) {
            this.duracion = duracion;
        }
        
    }
}
