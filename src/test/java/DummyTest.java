import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest {

    @Test
    public void test() {
        Assert.assertEquals(15, "15");
        Assert.assertEquals(15, String.valueOf(15));
        Assert.assertEquals(new Integer(15), Integer.valueOf(15));
        Assert.assertEquals("15", String.valueOf(15));
    }
}