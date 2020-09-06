package Day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SpartanTest {
    @DisplayName("GEt All Spartan")
    @Test
    public void testAllSpartans(){
       //String spartanURL = "http://54.162.37.32:8000/api/spartans";

        RestAssured.baseURI= "http://54.162.37.32:8000";
        RestAssured.basePath = "/api";

        given().header("Accept", "application/json").

        when().get("/spartans").
                then().
                statusCode(is(200));
    }

    @DisplayName("GEt All Spartan 2")
    @Test
    public void testAllSpartans2(){

    given()
    .baseUri("http://54.162.37.32:8000")
    .basePath("/api")
    .accept(ContentType.JSON).
    when()
            .get("/spartans")
            .then()
            .statusCode(is(200))
           // .contentType("application/xml;charset=UTF-8")
            //.contentType(is("application/xml;charset=UTF-8"))
            .contentType(ContentType.JSON);

    }
}
