package day05;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SecureSpartanTest {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.160.106.84";
        RestAssured.port= 8000;
        RestAssured.basePath="/api";


    }
    @DisplayName("Test GET /spartans/{id} Endpoint with no credential")
    @Test
    public void testGetSingleSpartanSecured(){
        given()
                .log().all()
                .pathParam("id",574)
                .when()
                .get("/spartan/{id}")
                .then()
                .log().all()
        .statusCode(401);
    }
    @DisplayName("TEst GET /spartan/{id} Endpoint with credentials")
    @Test
    public void testingGettingSpartanWithCredentials(){
        int  newId = createRandomSpartan();
        given()
                .log().all()

                .auth().basic("admin","admin")
                .pathParam("id",newId)
                .when()
                .get("/spartans/{id}")
                .then()
                .statusCode(200);
    }
public static int createRandomSpartan(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String gender = faker.demographic().sex();
        long phone = faker.number().numberBetween(1000000000L, 9999999999L);
         Spartan sp = new Spartan(name, gender, phone);
    Response response = given()
            .log().all()
            .auth().basic("admin","admin")
            .contentType(ContentType.JSON)
            .body(sp).
            when()
            .post("/spartans");
    return  response.path("data.id");

}

}
