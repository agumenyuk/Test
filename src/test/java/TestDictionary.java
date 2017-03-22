import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by aleksandrg on 3/20/2017.
 */

public class TestDictionary {
    @Test
    public void testDictionary() {

        Dictionary obj = new Dictionary();

        //ACT
        obj.store("");
        obj.store("test1");
        obj.store("TEST1");
        obj.store("TesT1");
        obj.store("Test2");
        obj.store("Test3");

        //ASSERT
        Assert.assertEquals(obj.getOccurrence(""), 1);
        Assert.assertEquals(obj.getOccurrence("test1"), 3);
        Assert.assertEquals(obj.getOccurrence("TEST1"), 3);
        Assert.assertEquals(obj.getOccurrence(null), 0);
        Assert.assertEquals(obj.getOccurrence("absent"), 0);
        Assert.assertEquals(obj.getSize(), 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Word cannot be null")
    public void testNullValueStore()
    {
        Dictionary obj = new Dictionary();
        obj.store(null);
    }
}
