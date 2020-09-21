package tests.api;

import io.qameta.allure.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class getPrivatOfficesTest extends BasePrivatApi {

    @Owner("artburov")
    @Feature("Privat offices")
    @Story("Privat offices in Zaporozhye")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing some specific Privat's office")
    @TmsLink("JIRA-2234")
    @Issue("Link to the created issue")
    @Step("Get all Privat's offices in Zaporozhye")
    @Test
    public void getPrivateOffices() {
        given()
                .spec(reqSpec)
                .queryParam("json")
                .queryParam("city", "Запорожье")
                .queryParam("address", "Космическая") // https://api.privatbank.ua/p24api/pboffice?json&city=Запорожье&address=Космическая

                .when()
                .log()
                .all(true)
                .get("/pboffice")

                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body("city",  hasItem("Запорожье"),
                        "index", hasItem("69050"));
    }
}
