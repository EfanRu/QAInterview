package utils;

import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WireMockHelper {
    public void deleteMapping(String uuidResp) {
        Response mockDeleteResp = given()
                .request(Method.DELETE, "/__admin/mappings/" + uuidResp);
        mockDeleteResp.then().statusCode(200);
    }

    public void deleteAllMapping() {
        Response mockDeleteResp = given()
                .request(Method.DELETE, "/__admin/mappings");
        mockDeleteResp.then().statusCode(200);
    }
}
