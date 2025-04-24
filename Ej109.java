import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author hulkiniano
 */
public class Ej109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String liga;
        do {
            liga = sc.nextLine();
            if (!liga.equals("FIN")) {
                partidos(sc);
            }
        } while (!liga.equals("FIN"));
    }

    public static void partidos(Scanner sc) {
        String txt;
        TreeMap<String, Integer> ganador = new TreeMap<String, Integer>();
        int cont = 0;
        do {
            txt = sc.nextLine();
            if (!txt.equals("FIN")) {
                String[] entrada = txt.split(" ");
                if (!ganador.containsKey(entrada[0])) {
                    ganador.put(entrada[0], 0);
                }
                if (!ganador.containsKey(entrada[2])) {
                    ganador.put(entrada[2], 0);
                }
                comparador(entrada[0], entrada[2], entrada[1], entrada[3], ganador);
                cont++;
            }
        } while (!txt.equals("FIN"));
        resultado(cont, ganador);
        ganador.clear();

    }

    public static void comparador(String e1, String e2, String p1, String p2, TreeMap<String, Integer> ganador) {
        if (Integer.parseInt(p1) > Integer.parseInt(p2)) {
            ganador.put(e1, (ganador.get(e1) + 2));
            ganador.put(e2, (ganador.get(e2) + 1));
        } else {
            ganador.put(e2, (ganador.get(e2) + 2));
            ganador.put(e1, (ganador.get(e1) + 1));
        }
    }

    public static void resultado(int cont, TreeMap<String, Integer> ganador) {
        String nombre = "";
        int max = 0;
        int totPart = (ganador.size() * (ganador.size() - 1)) - cont;
        for (Map.Entry<String, Integer> e : ganador.entrySet()) {
            if (max < e.getValue()) {
                nombre = e.getKey();
                max = e.getValue();
            }
        }
        for (Map.Entry<String, Integer> e : ganador.entrySet()) {
            if (max == e.getValue() && e.getKey() != nombre) {
                nombre = "EMPATE";
            }
        }
        System.out.println(nombre + " " + totPart);
    }
}
