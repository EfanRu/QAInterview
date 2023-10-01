package utils;

import org.testng.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        return DriverManager.getConnection(url, propsForSql);
    }

    public ResultSet execSqlQuery(String query) {
        try (Connection conn = new DBHelper().getConnection()) {
            return conn
                    .createStatement()
                    .executeQuery(query);
        } catch (SQLException e) {
            failOnSqlException(e);
        } catch (IOException e2) {
            failOnIOException(e2);
        }
        failOnWTFException();
        return null;
    }

    public int execCountSqlQuery(String query) {
        try (Connection conn = new DBHelper().getConnection()) {
            ResultSet rs = conn
                    .createStatement()
                    .executeQuery(query);
            if (rs.next())
                return rs.getInt("count");
        } catch (SQLException e) {
            failOnSqlException(e);
        } catch (IOException e2) {
            failOnIOException(e2);
        }
        failOnWTFException();
        return 0;
    }

    private void failOnSqlException(SQLException e) {
        Assert.fail("DB error: " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
    }

    private void failOnIOException(IOException e) {
        Assert.fail("IO error in DB connection : " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
    }

    private void failOnWTFException() {
        Assert.fail("It's something wrong! Code don't be exec in this place!");
    }
}
