package day03;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Practice1 {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.162.37.32";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }

    @DisplayName("simple test")
    @Test
    public void test1(){

        given()
                .log().all()
                .queryParam("gender", "Female")
        .when()
                .get("/spartans/search")
        .then()
                .statusCode(200);
    }
}
