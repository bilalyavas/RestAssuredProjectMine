package day04;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class PUtAndPatchRequestTest {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.162.37.32";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @DisplayName("Put Request body as a map")
    @Test
            public void testPutRequestWithMap() {
        String randomName = new Faker().name().firstName();

        Map<String, Object> updatedBody = new LinkedHashMap<>();
        updatedBody.put("name",randomName);
        updatedBody.put("gender","Female");
        updatedBody.put("phone",8765654332l);



        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(updatedBody)

                .when()
                .put("/spartans/{id}",104)
                .then()
                .log().all()
                .statusCode(is(204));

       // when()
        //        .get("/spartans/{id}", 104)
           //     .then()
            //    .statusCode(200)
             //   .body("name", is(randomName));




    }
    @DisplayName("Patch request")
    @Test
    public void testPathPartialUpdate(){
        String randomName = new Faker().name().firstName();
        String patchbody = " \"name\" : \""+randomName+"\"";
        Map<String, Object> patchBodyMap = new HashMap<>();
       patchBodyMap.put("name", randomName);
       given()
               .log().all()
               .contentType(ContentType.JSON)
               .body(patchBodyMap)
               .when()
               .patch("/spartans/{id}",17)
               .then()
               .log().all()
               .statusCode(204);
    }
}
