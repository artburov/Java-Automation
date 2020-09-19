package tests.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class getPrivatOfficesTest extends BasePrivatApi {

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
