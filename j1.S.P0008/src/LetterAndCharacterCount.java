
import java.util.TreeMap;
import java.util.StringTokenizer;

public class LetterAndCharacterCount {

    /*
     * Main function of program
     */
    public void run() {
        String input = InputValidation.getString("Enter your content: ");
 //  phân biệt hoa thường 
 input = input.toLowerCase();
 

        countWord(input);
        countCharacter(input);
    }
// dem so lan xuat hien của chuoi 
    private void countWord(String input) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        System.out.println(wordMap);
    }
// dem xo lan xuat hien cua tung ky tu (  bo qua khonga trnag )
    private void countCharacter(String input) {
        TreeMap<Character, Integer> charMap = new TreeMap<>();
// bo qua khoang trnag
        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                continue;
            }

            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else {
                charMap.put(ch, 1);
            }
        }

        System.out.println(charMap);
    }

}
