package Day02;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class SpartanSearchTest_QueryParam {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://54.162.37.32:8000";
        RestAssured.basePath = "/api";

    }

    @DisplayName("Testing /spartans/search Endpoint")
    @Test
    public void testSearch(){
        given().
                log().all()
                .queryParam("gender","Male")
                .queryParam("nameContains","e")
                .when()
                .get(" spartans/search").
                then()
                .log().all()
                .statusCode(200)
        .body("numberOfElements", is(34))
        ;
    }

}