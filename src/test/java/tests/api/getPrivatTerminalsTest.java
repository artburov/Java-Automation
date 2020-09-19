package tests.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class getPrivatTerminalsTest extends BasePrivatApi {

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