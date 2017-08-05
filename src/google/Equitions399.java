package google;

import java.util.*;

public class Equitions399 {
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if(equations == null || equations.length == 0) return new double[0];

        Set<String> dic = new HashSet<>();
        double[] out = new double[queries.length];
        for (String[] equ : equations) {
            dic.add(equ[0]);
            dic.add(equ[1]);
        }

        Map<String, Double> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String key = equations[i][0].concat(equations[i][1]);
            if (!map.containsKey(key)) {
                map.put(key, values[i]);
            }
            String key1 = equations[i][1].concat(equations[i][0]);
            if (!map.containsKey(key1)) {
                map.put(key1, 1 / values[i]);
            }
        }

        for (int i = 0; i < equations.length; i++) {
            for (int j = i; j < equations.length; j++) {
                if (equations[i][1].equals(equations[j][0])) {
                    String key1 = equations[i][0].concat(equations[j][1]);
                    String key2 = equations[j][1].concat(equations[i][0]);
                    if (!map.containsKey(key1)) {
                        map.put(key1, values[i] * values[j]);
                    }
                    if (!map.containsKey(key2)) {
                        map.put(key2, values[j] * values[i]);
                    }
                }
            }
        }

        for (int i = 0; i < equations.length; i++) {
            for (int j = i; j < equations.length; j++) {
                if (equations[i][1].equals(equations[j][1])) {
                    String key1 = equations[i][0].concat(equations[j][0]);
                    String key2 = equations[j][0].concat(equations[i][0]);
                    if (!map.containsKey(key1)) {
                        map.put(key1, values[i] / values[j]);
                    }
                    if (!map.containsKey(key2)) {
                        map.put(key2, values[j] / values[i]);
                    }
                }
            }
        }

        for(String ch : dic) {
            map.put(ch.concat(ch), 1.0);
        }

        int i = 0;
        for (String[] query : queries) {
            if (map.containsKey(query[0].concat(query[1]))) {
                out[i++] = map.get(query[0].concat(query[1]));
            } else {
                out[i++] = -1.0;
            }
        }
        return out;
    }

    public static void main(String[] args) {
//        String[][] equations = {{"a", "b"}, {"b", "c"}};
//        double[] values = {2.0, 3.0};
//        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        String[][] equations = {{"a", "e"}, {"b", "e"}};
        double[] values = {4.0, 3.0};
        String[][] queries = {{"a", "b"}, {"e", "e"}, {"x", "x"}};
        double[] out = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(out));
    }
}

