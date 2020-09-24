package tests.api;

import io.qameta.allure.Step;
import org.junit.Test;
import tests.api.helpers.MethodHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetPrivatExchangeRateArchiveTest extends MethodHelper {

    @Step("Get all archive exchange rate of currencies")
    @Test
    public void getPrivateExchangeRateArchive() {
        //Create GET test request using map collection with data instead of a given section
        Map<String, Object> testData = new HashMap<>();
        testData.put("json", null);
        testData.put("exchange", null);
        testData.put("coursid", 5); // https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5

        get(testData, "/pubinfo")

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