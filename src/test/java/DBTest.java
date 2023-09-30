import org.testng.annotations.Test;
import utils.DBHelper;

/**
 * Testing work with DB and SQL query.
 * fixme Schema DB present in src/test/resources/DBSchema.png
 */
public class DBTest {
    @Test
    public void testDBConnect() {
        new DBHelper().execNativeQuery("");
    }
}
