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
     * Task: write a select query of the counts of customer whose email contains 'customer.org'
     */
    @Test
    public void checkSelectQuery() {
        int count = new DBHelper().execCountSqlQuery("");
        Assert.assertEquals(count, 599);
    }

    /**
     * Task: write a select query of the counts of customer whose lives in Moscow
     */
    @Test
    public void checkSelectQuery2() {
        int count = new DBHelper().execCountSqlQuery("");
        Assert.assertEquals(count, 1);
    }

    /**
     * Task: write a select query of the counts of staff whose username does not begin with M
     * and whose store is located in a city starting with M
     * The best practice is written query in database tools.
     */
    @Test
    public void checkSelectQuery3() {
        int count = new DBHelper().execCountSqlQuery("");
        Assert.assertEquals(count, 1);
    }
}
