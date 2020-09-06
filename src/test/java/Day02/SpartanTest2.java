package Day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class SpartanTest2 {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI= "http://54.162.37.32:8000";
        RestAssured.basePath = "/api";

    }
    @DisplayName("GEt All Spartan")
    @Test
    public void testAllSpartans(){
       //String spartanURL = "http://54.162.37.32:8000/api/spartans";


        given().header("Accept", "application/json").

        when().get("/spartans").
                then().
                statusCode(is(200));
    }

    @DisplayName("GEt All Spartan 2")
    @Test
    public void testAllSpartans2(){

    given()
   // .baseUri("http://54.162.37.32:8000")
   // .basePath("/api")
    .accept(ContentType.JSON).
    when()
            .get("/spartans")
            .then()
            .statusCode(is(200))
           // .contentType("application/xml;charset=UTF-8")
            //.contentType(is("application/xml;charset=UTF-8"))
            .contentType(ContentType.JSON);

    }

    @DisplayName("GEt 1 Spartan Test")
    @ Test
    public void testSingleSpartan(){
        given()
                .log().all()
       // .log().body().
        //.log().uri().
      .when()
                .get("/spartans/20")
                .prettyPeek()
                .then()
              //  .log().all()
                //.log().ifValidationFails()
                .statusCode(is(200));
    }



    @DisplayName("Testing /Hello again")
    @Test
    public void testHello(){

        given()
                // .baseUri("http://54.162.37.32:8000")
                // .basePath("/api")
                .accept(ContentType.TEXT).
                when()
                .get("/hello")
                .then()
                .statusCode(is(200))
                // .contentType("application/xml;charset=UTF-8")
                //.contentType(is("application/xml;charset=UTF-8"))
                .contentType(ContentType.TEXT)
        .body(equalTo("Hello from Sparta"));


    }

}
