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
}
