package tests.api;

import io.qameta.allure.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class getPrivatTerminalsTest extends BasePrivatApi {

    @Owner("artburov")
    @Feature("Privat terminals")
    @Story("Privat terminals in Zaporozhye")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Testing some specific Privat's terminal")
    @TmsLink("JIRA-1234")
    @TmsLinks({@TmsLink("JIRA-777"), @TmsLink("JIRA-888")})
    @Link("Link to the bug report or something else")
    @Issue("Link to the created issue")
    @Issues(@Issue("more issue links"))
    @Test
    public void getPrivateBankomats() {
        given()
                .spec(reqSpec)
                .queryParam("json")
                .queryParam("tso")
                .queryParam("address", "Украина,область Запорожская,город Запорожье")
                .queryParam("city", "Запорожье") // https://api.privatbank.ua/p24api/infrastructure?json&tso&address=&city=Запорожье

                .when()
                .log()
                .all(true)
                .get("/infrastructure")

                .then()
                .log()
                .all(true)
                .spec(resSpec)
                .body("devices.type", hasItem("TSO"),
                        "devices.tw.mon", hasItem("08:00 - 19:00"),
                        "devices.tw.tue", hasItem("08:00 - 19:00"),
                        "devices.placeRu", hasItem("Детская Больница №5"),
                        "devices.cityEN", hasItem("Zaporizhzhia"))
                .body("city", equalTo("Запорожье"));
    }
}