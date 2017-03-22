/**
 * Created by aleksandrg on 3/20/2017.
 */
public interface isDictionary {
    void store(String word) throws Exception;
    int getOccurrence(String word) throws Exception;
}
