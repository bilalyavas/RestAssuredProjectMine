package day05;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;



public class PostRequestWithFormAsBody {

    //http://library1.cybertekschool.com/rest/v1/login
    //librarian69@library
    //       KNPXrm3S

@BeforeAll
    public static void init(){
    RestAssured.baseURI = "http://library1.cybertekschool.com";
    RestAssured.basePath= "rest/v1";

}
@DisplayName("POST/loginrequest test")
@Test
    public void testLoginEndPoint(){

    given()
            .log().all()
            .contentType(ContentType.URLENC)
            .formParam("email","librarian69@library")
            .formParam("password","KNPXrm3S")
            .when()
            .post("/login")
            .then()
            .log().all()
            .statusCode(200)
    .body("token",is(notNullValue()))

    ;
    }


    @DisplayName("Testing out the utility")
    @Test
    public void runningUtilityMethod(){
        System.out.println(loginAndGetToken("librarian69@library","KNPXrm3S"));
    }

    public String loginAndGetToken(String username, String password){
    String token = "";
        Response response =   given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("email",username)
                .formParam("password",password)
                .when()
                .post("/login");
        //token = response.path("token");
        token= response.jsonPath().getString("token");

    return "TOKEN!!";
    }
}

