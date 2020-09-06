package Day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OpenMovieDB_Test {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://www.omdbapi.com";

    }
    @DisplayName("Test Movie API")
    @Test
    public void testMovies(){
        given().
                log().all()
                .queryParam("apikey", "e9a02d4f")
                .queryParam("t","'Boss Baby'")
                .queryParam("plot","full")
                .when()
                .get().
                then()
                .log().all()
                .statusCode(200)
                .body("Title", is("The Boss Baby"))
                 .body("Title", containsString("Boss Baby"))
        .body("Ratings[0].Value",is("6.3/10"))
        .body("Ratings[-1].Value",is("50/100"))
        ;
    }

}
