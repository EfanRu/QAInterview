import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WireMockHelper;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static utils.PropsHelper.getProps;

public class APITest {
    final int wireMockPort = Integer.parseInt(getProps().getProperty("wireMock.port"));
    final String wireMockUrl = getProps().getProperty("wireMock.url");
    WireMock wireMock = new WireMock(wireMockUrl, wireMockPort);

    public APITest() throws IOException {
    }

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
     * Take any one book and check with Assert first name.
     * Info {@link # http://restful-booker.herokuapp.com/apidoc/index.html}
     */
    @Test
    public void test1() {

    }

    @Test
    public void testWireMock() throws IOException {
        RestAssured.baseURI = wireMockUrl;
        RestAssured.port = wireMockPort;
        File stubBody = new File("src/test/resources/mockBody/testWireMock.json");

        Response mockResp = given()
                .body(FileReader.readToString(stubBody, "UTF-8"))
                .when()
                .request(Method.POST, "/__admin/mappings");
        mockResp.body().prettyPrint();
        mockResp.then().statusCode(201);
        String uuidResp = mockResp.getBody().path("uuid");


        Response response = given()
                .request(Method.GET, "/test");
        response.body().prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.getBody().prettyPrint(), "Hello wireMock!");

        new WireMockHelper().deleteMapping(uuidResp);
    }

    /**
     * Create stub in WireMock for method GET URI /client/cards with mockBody {@link /src/test/resource/mockBody/clientCards.json}
     * Validate values:
     * - openDate date pattern;
     * - balance amount is string;
     * - subject contains item "Active";
     * - isActive flag true.
     * Hard task: use WireMock methods
     */
    @Test
    public void test2() {
        File stubBody = new File("src/test/resources/mockBody/clientCards.json");

    }
}
