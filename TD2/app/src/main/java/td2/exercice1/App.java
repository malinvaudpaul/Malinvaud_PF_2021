package td2.exercice1;

import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Question1
        Somme<Integer> sommeInt = (x, y) -> x + y;
        Somme<Double> sommeDouble = (x, y) -> x + y;
        Somme<Long> sommeLong = (x, y) -> x + y;
        Somme<String> sommeString = (x, y) -> x.concat(y);

        // Question2
        /*
         * deux lambdas implémentations de ToString, une pour les listes de String (l2s)
         * et une pour les map String → Integer (m2s) dont l’effet est respectivement de
         * créér une chaîne de la forme "e1, e2, …" et de la forme "k1: v1, k2: v2, …".
         */
        List<String> l2s = { "e1", "e2" };
        ToString<List<String>> toStringList = x -> {
            String y = "";
            return x.forEach(y.concat(x));
        };
        l2s.show();
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("k1", 1);
        hm.put("k2", 2);
        ToString<HashMap<String, Integer>> toStringMap = x -> {
        };
    }
}
