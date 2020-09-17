package tests.api;

import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class PrivatApiTest extends BasePrivatApiTest {


    @Test
    public void getPrivateExchangeRateArchive() {
        given().spec(reqSpec).queryParam("coursid", 5)

                .when()
                .log()
                .all(true)
                .get("/pubinfo")

                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body(matchesJsonSchema(
                        new File(System.getProperty("user.dir")
                                + "/src/main/resources/schema-validation/getPubinfoSchema.json")));
/*
                .assertThat()
                .statusCode(200);

                //Assert that "baseCurrency" equal to 980
                .body("baseCurrency", equalTo(980))

                //Assert that array "exchangeRate" have a lot of similar properties "baseCurrency"
                .body("exchangeRate.baseCurrency", everyItem(equalTo("UAH")));
*/

    }

}
