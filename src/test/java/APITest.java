import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.port = 443;
    }
    @Test
    public void checkWorking() {
        Response response = given()
                .header(new Header("Content-Type", "application/json"))
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .when()
                .request(Method.POST, "/auth");
        response.body().prettyPrint();
        response.then().statusCode(200);
    }

    /**
     * With token from {@link #checkWorking()} get one book and check with Assert fist name
     * Info {@link # http://restful-booker.herokuapp.com/apidoc/index.html}
     */
    @Test
    public void test1() {

    }
}
