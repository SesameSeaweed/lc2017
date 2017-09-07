import java.util.ArrayList;
import java.util.List;

public class TextJustification68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder("");
        List<String> temp = new ArrayList<>();
        List<String> out = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(words[i].length() > maxWidth) return new ArrayList<>();
            sb.append(words[i]);
            if(sb.length() > maxWidth) {
                temp.add(sb.substring(0, sb.lastIndexOf(" ")));
                sb = new StringBuilder("");
                i--;
            }else {
                sb.append(" ");
            }
        }
        if(sb.length() > 0) temp.add(sb.substring(0, sb.length()-1));

        if(maxWidth == 1) return temp;
        for(int j = 0; j < temp.size(); j++) {
            String[] word = temp.get(j).split(" ");
            StringBuilder item = new StringBuilder("");
            if(word.length == 1) {
                item.append(word[0]);
                while(item.length() < maxWidth) {
                    item.append(" ");
                }
                out.add(item.toString());
                continue;
            }
            int space = maxWidth - temp.get(j).length() + word.length-1;
            int div = space % (word.length - 1);
            int count = space / (word.length - 1);

            StringBuilder spaceReal = new StringBuilder("");
            for(int i = 0; i < count; i++) {
                spaceReal.append(" ");
            }
            for(int i = 0; j != temp.size()-1 && i < word.length; i++) {
                if(i < word.length - 1) item.append(word[i]).append(spaceReal);
                else item.append(word[i]);
                if(div-- > 0) item.append(" ");
            }

            for(int i = 0; j == temp.size()-1 && i < word.length; i++) {
                if(i < word.length - 1) item.append(word[i]).append(spaceReal);
                else item.append(word[i]);
                if(word.length - i < div) item.append(" ");
            }
            out.add(item.toString());
        }
        return out;
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {"a","b","c","d","e"};
//        String[] words = {"Listen","to","many,","speak","to","a","few."};
        List<String> out = fullJustify(words, 16);
        System.out.println(out);
    }
}
