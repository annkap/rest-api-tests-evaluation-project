import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;

public class Test_PeselValidator_GET_LeapYears extends BaseTest {

    @Test
    public void test_ValidPeselForLeapYear_YearDividedBy4_notDividedBy100() {
        String expectedDateOfBirth = "2012-02-29T00:00:00";
        Response actualResponse = get("/Pesel?pesel=12222960321");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPeselLeapYear_YearDividedby400() {
        String expectedDateOfBirth = "2000-02-29T00:00:00";
        Response actualResponse = get("/Pesel?pesel=00222941880");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_InvalidPesel29thFebForNotALeapYear_YearDividedby4_andDividedBy100() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=00022930989")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }
}
