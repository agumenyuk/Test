import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Created by aleksandrg on 3/20/2017.
 */
public class Dictionary implements isDictionary {
    private HashMap<String, Integer> list;

    Dictionary(){
        list = new HashMap<>();
    }


    public void store(String word) {
        if (word == null)
        {
            throw new IllegalArgumentException("Word cannot be null");
        }
        list.compute(word.toLowerCase(), (String key, Integer value) -> value == null ? 1 : value + 1);
    }

    public int getOccurrence(String word) {
        if (word == null || !list.containsKey(word.toLowerCase()))
        {
            return 0;
        }
        return list.get(word.toLowerCase());
    }

    public int getSize(){
        return list.size();
    }

    public static void main(String args[])
    {
        Dictionary list = new Dictionary();
        String[] words = {"test1", "test1", "test1", "ttt", "tt3t", "tt5t", "t2tt"};
        for (String word : words)
        {
            list.store(word);
            System.out.print("Occurrence of word: "+ word +"; is: " + list.getOccurrence(word) + "\n");
        }
        System.out.print("Total unique words in dictionary is: " + list.getSize());
    }
}
