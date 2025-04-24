import java.util.*;

/**
 *
 * @author hulkiniano
 */
public class Ej270 {

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
        TreeMap<String, Integer> l = new TreeMap<String, Integer>();
        String valor, nombre;
        for (int i = 0; i < n; i++) {
            nombre = sc.nextLine();
            valor = sc.nextLine();
            insertar(l, valor, nombre);
        }
        salida(l);
    }
    
    public static void insertar(TreeMap<String, Integer> l, String valor, String nombre) {
        if (!l.containsKey(nombre)) {
            l.put(nombre, 0);
        }
        l.put(nombre, l.get(nombre) + validar(valor, l));
    }
    
    public static int validar(String valor, TreeMap<String, Integer> l){
        if (valor.equals("CORRECTO")) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public static void salida(TreeMap<String, Integer> l) {
        for (Map.Entry<String, Integer> entry : l.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            if (l.get(key) != 0) {
                System.out.println(key + ", " + val);
            }
        }
        System.out.println("---");
    }
}
