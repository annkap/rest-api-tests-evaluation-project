import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Test_PeselValidator_GET_endOfMonth_BV extends BaseTest{
    @Test
    public void test_LastValidDay_January() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17213105066")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_January() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17213205066")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_February() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17222878245")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_February() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17222978245")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_March() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17233193391")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvastValidDay_March() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17233293391")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_April() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17243007743")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_April() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17243107743")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_May() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17253124560")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_May() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17253224560")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_June() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17263045677")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvlidDay_June() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17263145677")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_July() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17273140120")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_July() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17273240120")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_August() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17283130814")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_August() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17283230814")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_September() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17293002736")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_September() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17293102736")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_October() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17303102522")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_October() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17303202522")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_November() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17313032693")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_November() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17313132693")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }

    @Test
    public void test_LastValidDay_December() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17323114123")
                .then()
                .extract()
                .path("isValid");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_FirstInvalidDay_December() {
        Boolean actualResult = when()
                .get("/Pesel?pesel=17323214123")
                .then()
                .extract()
                .path("isValid");

        Assert.assertFalse(actualResult);
    }
}
