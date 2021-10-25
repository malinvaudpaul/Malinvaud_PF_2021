package td2.exercice1;

import java.util.ArrayList;
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
        List<String> l2s = new ArrayList<>();
        l2s.add("e1");
        l2s.add("e2");
        ToString<List<String>> toStringList = x -> {
            final StringBuilder builder = new StringBuilder();
            x.forEach((val) -> {
                builder.append(val + ", ");
            });
            return builder.toString();
        };
        System.out.println(toStringList.show(l2s));

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("k1", 1);
        hm.put("k2", 2);
        ToString<HashMap<String, Integer>> toStringMap = x -> {
            final StringBuilder builder = new StringBuilder();
            x.forEach((key, val) -> {
                builder.append(String.format("%s : %d, ", key, val));
            });
            return builder.toString();
        };
        System.out.println(toStringMap.show(hm));

    }
}
