import io.restassured.RestAssured;

public class BaseTest {


    public BaseTest() {
        RestAssured.baseURI = "https://peselvalidatorapitest.azurewebsites.net/api";
    }

    public String firstErrorCodePath = "errors[0].errorCode";
    public String firstErrorMessagePath = "errors[0].errorMessage";
    public String secondErrorCodePath = "errors[1].errorCode";
    public String secondErrorMessagePath = "errors[1].errorMessage";

    /*@BeforeClass
    public void before(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }*/
}
