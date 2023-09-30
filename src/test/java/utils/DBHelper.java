package utils;

import org.testng.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import static utils.PropsHelper.getProps;

public class DBHelper {
    public Connection getConnection() throws IOException, SQLException {
        String url = getProps().getProperty("db.url");
        Properties propsForSql = new Properties();
        propsForSql.setProperty("user", getProps().getProperty("db.user"));
        propsForSql.setProperty("password", getProps().getProperty("db.password"));
        propsForSql.setProperty("ssl", "true");
        return DriverManager.getConnection(url, propsForSql);
    }

    public String execNativeQuery(String query) {
        try (Connection conn = new DBHelper().getConnection()) {
            return conn.nativeSQL(query);
        } catch (SQLException e) {
            Assert.fail("DB error: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        } catch (IOException e2) {
            Assert.fail("IO error in DB connection : " + e2.getMessage() + "\n" + Arrays.toString(e2.getStackTrace()));
        }
        Assert.fail("It's something wrong! Code don't be exec in this place!");
        return "WTF";
    }
}
