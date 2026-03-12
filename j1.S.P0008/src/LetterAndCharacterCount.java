
import java.util.TreeMap;
import java.util.StringTokenizer;

public class LetterAndCharacterCount {

    private String input;

    public LetterAndCharacterCount(String input) {
        this.input = input.toLowerCase();
    }

// dem so lan xuat hien của chuoi 
    public TreeMap<String, Integer> countWord() {

        TreeMap<String, Integer> worMap = new TreeMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (worMap.containsKey(word)) {
                worMap.put(word, worMap.get(word) + 1);
            } else {
                worMap.put(word, 1);

            }
        }
        return worMap;
    }

// dem xo lan xuat hien cua tung ky tu (  bo qua khonga trnag )
    public TreeMap<Character, Integer> countCharacter() {
        TreeMap< Character, Integer> CharMap = new TreeMap<>();
        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (CharMap.containsKey(ch)) {
                CharMap.put(ch, CharMap.get(ch) + 1);

            } else {
                CharMap.put(ch, 1);

            }
        }
        return CharMap;
    }
}
