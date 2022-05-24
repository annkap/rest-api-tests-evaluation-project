import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;

public class Test_PeselValidator_GET_CenturiesBV extends BaseTest {

    @Test
    public void test_ValidPesel_19th_century_firstDay() {
        String expectedDateOfBirth = "1800-01-01T00:00:00";
        Response actualResponse = get("/Pesel?pesel=00810111112");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_19th_century_lastDay() {
        String expectedDateOfBirth = "1899-12-31T00:00:00";
        Response actualResponse = get("/Pesel?pesel=99923111117");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_20th_century_firstDay() {
        String expectedDateOfBirth = "1900-01-01T00:00:00";
        Response actualResponse = get("/Pesel?pesel=00010167744");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_20th_century_lastDay() {
        String expectedDateOfBirth = "1999-12-31T00:00:00";
        Response actualResponse = get("/Pesel?pesel=99123111113");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_21th_century_firstDay() {
        String expectedDateOfBirth = "2000-01-01T00:00:00";
        Response actualResponse = get("/Pesel?pesel=00210152681");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_21th_century_lastDay() {
        String expectedDateOfBirth = "2099-12-31T00:00:00";
        Response actualResponse = get("/Pesel?pesel=99323111119");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_22th_century_firstDay() {
        String expectedDateOfBirth = "2100-01-01T00:00:00";
        Response actualResponse = get("/Pesel?pesel=00410198456");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_22th_century_lastDay() {
        String expectedDateOfBirth = "2199-12-31T00:00:00";
        Response actualResponse = get("/Pesel?pesel=99523111115");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_23th_century_firstDay() {
        String expectedDateOfBirth = "2200-01-01T00:00:00";
        Response actualResponse = get("/Pesel?pesel=00610111116");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }

    @Test
    public void test_ValidPesel_23th_century_lastDay() {
        String expectedDateOfBirth = "2299-12-31T00:00:00";
        Response actualResponse = get("/Pesel?pesel=99723111111");
        String actualDateOfBirth = actualResponse.path("dateOfBirth");

        Assert.assertEquals(actualDateOfBirth, expectedDateOfBirth);
    }
}