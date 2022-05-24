import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class X_Test_CurrencyConverterAPI {

    @Test
    public void test_CurrencyConverter_isUSD_PLN_RateHighEnough() {
        float expectedRate = 4.20F;
        given()
                .log().all()
                .when()
                .get("https://free.currconv.com/api/v7/convert?q=USD_PLN&compact=ultra&apiKey=155a03b41646727d5e20")
                .then()
                .body("USD_PLN", is(greaterThan(expectedRate)));
    }
}
