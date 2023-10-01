import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Testing work with DB and SQL query.
 * Schema DB present in src/test/resources/database-diagram.pdf
 */
public class DBTest {
    @Test
    public void testDBConnect() throws SQLException {
        ResultSet rs = new DBHelper().execSqlQuery("select * from city");
        Assert.assertEquals(rs.findColumn("city_id"), 1);
    }

    /**
     * Task: write simple select counts of customer where email contains 'customer.org'
     */
    @Test
    public void checkSelectQuery() {
        int count = new DBHelper().execCountSqlQuery("");
        Assert.assertEquals(count, 599);
    }
}
