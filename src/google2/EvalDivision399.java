package google2;

import java.util.*;

public class EvalDivision399 {
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> dict = new HashMap<>();
        double[] out = new double[queries.length];

        for(int i = 0; i < equations.length; i++) {
            if(!dict.containsKey(equations[i][0])) {
                dict.put(equations[i][0], new HashMap<>());
            }
            if(!dict.containsKey(equations[i][1])) {
                dict.put(equations[i][1], new HashMap<>());
            }
            dict.get(equations[i][0]).put(equations[i][1], values[i]);
            dict.get(equations[i][1]).put(equations[i][0], 1.0/values[i]);
        }

        for(int i = 0; i < queries.length; i++) {
            if(dict.containsKey(queries[i][0]) && dict.containsKey(queries[i][1])) {
                if(dict.get(queries[i][0]).containsKey(queries[i][1])) {
                    if(queries[i][0] == queries[i][1]) {
                        out[i] = 1.0;
                        break;
                    }
                    out[i] = dict.get(queries[i][0]).get(queries[i][1]);
                }else {
                    out[i] = dfs(queries[i][0], queries[i][1], dict, 1.0, new HashSet<>());
                }
            }else {
                out[i] = -1.0;
            }
        }
        return out;
    }

    private static double dfs(String s, String t, Map<String, Map<String, Double>> dict, double val, HashSet<String> visited) {
        if(dict.get(s).containsKey(t)) return val*dict.get(s).get(t);
        double temp = 0.0;
        for(String neighbor : dict.get(s).keySet()) {
            if(visited.add(neighbor)) {
                temp = dfs(neighbor,t, dict, val*dict.get(s).get(neighbor), visited);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] out = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(out));
    }
}
