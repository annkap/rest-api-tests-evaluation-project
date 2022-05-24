import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Test_PeselValidator_GET_BasicChecks extends BaseTest {

    @Test
    public void test_ValidPesel_GetStatusCodeOk() {
        when()
                .get("/Pesel?pesel=84032915538")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_InvalidPesel_EmptyPesel_StatusCodeBadRequest() {
        when()
                .get("/Pesel?pesel=")
                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    public void test_ValidPesel_ValidationConfirmation() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=84032915538")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_InvalidPesel_ValidationConfirmation() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=84032915530")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_ValidPeselTest_GenderCheck_Male() {
        String actualGender = when()
                .get("/Pesel?pesel=84032915538")
                .then()
                .extract()
                .path("gender");

        Assert.assertEquals(actualGender, "Male");
    }

    @Test
    public void test_ValidPeselTest_GenderCheck_Female() {
        String actualGender = when()
                .get("/Pesel?pesel=07243044545")
                .then()
                .extract()
                .path("gender");

        Assert.assertEquals(actualGender, "Female");
    }
}
