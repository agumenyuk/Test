import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by aleksandrg on 3/20/2017.
 */

public class TestDictionary {

    private Dictionary obj;

    @BeforeMethod
    public void setUp() {
        obj = new Dictionary();
    }


    @Test
    public void testRegister(){
        //ACT
        obj.store("test1");
        obj.store("TEST1");
        obj.store("TesT1");
        obj.store("Test2");
        obj.store("Test3");

        //ASSERT
        Assert.assertEquals(obj.getOccurrence("test1"), 3);
        Assert.assertEquals(obj.getOccurrence("TEST1"), 3);
        Assert.assertEquals(obj.getOccurrence("TEST3"), 1);
        Assert.assertEquals(obj.getOccurrence("Test2"), 1);
        Assert.assertEquals(obj.getSize(), 3);
    }

    @Test
    public void testEmpty(){
        obj.store("");
        Assert.assertEquals(obj.getOccurrence(""), 1);
    }

    @Test
    public void testAbsent(){
        Assert.assertEquals(obj.getOccurrence("some word"), 0);
        Assert.assertEquals(obj.getOccurrence(null), 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Word cannot be null")
    public void testNull()
    {
        obj.store(null);
    }
}
