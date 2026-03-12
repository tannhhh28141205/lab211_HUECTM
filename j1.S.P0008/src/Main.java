
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String input = InputValidation.getString("Enter content:");

        LetterAndCharacterCount counter = new LetterAndCharacterCount(input);

        TreeMap<String, Integer> wordMap = counter.countWord();
        TreeMap<Character, Integer> charMap = counter.countCharacter();

        System.out.println(wordMap);
        System.out.println(charMap);

    }
}
