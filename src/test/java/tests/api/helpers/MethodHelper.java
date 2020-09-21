package tests.api.helpers;

import io.restassured.response.Response;
import tests.api.BasePrivatApi;

import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class MethodHelper extends BasePrivatApi {

    protected Response get(Map<String, Object> params, String partOfUrl) {
        return  given()
                .spec(reqSpec)
                .queryParams(params)

                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }

    protected Response get(String partOfUrl) {
        return  given()
                .spec(reqSpec)

                .when()
                .log()
                .all(true)
                .get(partOfUrl);
    }
}
