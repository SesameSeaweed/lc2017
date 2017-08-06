import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
    public static List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                out.add("FizzBuzz");
                continue;
            }
            if(i % 5 == 0) {
                out.add("Buzz");
                continue;
            }
            if(i % 3 == 0) {
                out.add("Fizz");
                continue;
            }
            out.add(Integer.toString(i));
        }
        return out;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> out = fizzBuzz(n);
        System.out.print(out);
    }

}
