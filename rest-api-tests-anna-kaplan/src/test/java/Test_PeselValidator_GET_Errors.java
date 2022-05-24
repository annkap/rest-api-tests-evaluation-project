import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class Test_PeselValidator_GET_Errors extends BaseTest {

    @Test
    public void test_InvalidPeselTest_InvalidLength_ToShortPesel() {
        Response actualResponse = get("/Pesel?pesel=84032913");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidLength.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidLength.message);
    }

    @Test
    public void test_InvalidPeselTest_InvalidLength_ToLongPesel() {
        Response actualResponse = get("/Pesel?pesel=961007647790");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidLength.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidLength.message);
    }

    @Test
    public void test_InvalidPeselTest_InvalidCharacters_SpecialSigns() {
        Response actualResponse = get("/Pesel?pesel=!@#$%^&*()!");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidCharacters.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidCharacters.message);
    }

    @Test
    public void test_InvalidPeselTest_InvalidCharacters_Letters() {
        Response actualResponse = get("/Pesel?pesel=peselAsWord");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidCharacters.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidCharacters.message);
    }

    @Test
    public void test_ValidPeselTest_InvalidCharacters_Whitespaces() {
        //as confirmed with 'pruduct owner' pesel with whitespaces should be recognized as a valid one
        Response actualResponse = get("/Pesel?pesel=96   10  07 6 4 779");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        Boolean actualResult = actualResponse.path("isValid");
        Assert.assertEquals(actualErrorCode, null);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void test_InvalidPeselTest_InvalidYearAndMonth() {
        Response actualResponse = get("/Pesel?pesel=99140111118");
        String actualErrorCodeYear = actualResponse.path(firstErrorCodePath);
        String actualErrorMessageYear = actualResponse.path(firstErrorMessagePath);
        String actualErrorCodeMonth = actualResponse.path(secondErrorCodePath);
        String actualErrorMessageMonth = actualResponse.path(secondErrorMessagePath);
        Assert.assertEquals(actualErrorCodeYear, ErrorRepository.invalidYear.code);
        Assert.assertEquals(actualErrorCodeMonth, ErrorRepository.invalidMonth.code);
        Assert.assertEquals(actualErrorMessageYear, ErrorRepository.invalidYear.message);
        Assert.assertEquals(actualErrorMessageMonth, ErrorRepository.invalidMonth.message);
    }

    @Test
    public void test_InvalidPeselTest_InvalidDay00() {
        Response actualResponse = get("/Pesel?pesel=96100064770");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidDay.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidDay.message);
    }

    @Test
    public void test_InvalidPeselTest_InvalidDay32() {
        Response actualResponse = get("/Pesel?pesel=96103264771");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidDay.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidDay.message);
    }

    @Test
    public void test_InvalidPeselTest_InvalidCheckSum() {
        Response actualResponse = get("/Pesel?pesel=96100764770");
        String actualErrorCode = actualResponse.path(firstErrorCodePath);
        String actualErrorMessage = actualResponse.path(firstErrorMessagePath);
        Assert.assertEquals(actualErrorCode, ErrorRepository.invalidCheckSum.code);
        Assert.assertEquals(actualErrorMessage, ErrorRepository.invalidCheckSum.message);
    }
}
