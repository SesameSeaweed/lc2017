package google;

import java.util.ArrayList;
import java.util.List;


public class ReadBinaryWatch401 {
    public static List<String> readBinaryWatch(int num) {
        List<String> out = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    out.add(String.format("%d:%02d", h, m));
        return out;
    }

   public static void main(String[] args) {

   }
}
