package tests.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;

public abstract class BasePrivatApiTest {
    protected Logger log = LogManager.getLogger(this.getClass().getName());

    protected RequestSpecification reqSpec;
    protected ResponseSpecification resSpec;


    @Before
    public void setUp() {
        this.reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.privatbank.ua/p24api")
                .addQueryParam("json")
                .addQueryParam("exchange")
                .build();
        this.resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                //Assert that at least one base_ccy equal to USD
                .expectBody("base_ccy", hasItem(equalTo("USD")))
                .build();
    }
}
