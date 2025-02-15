package day04;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostRequestTest {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.162.37.32";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @DisplayName("Post request with String as Body")
    @Test
    public void    testPostWithStringBody( ) {
        Faker faker = new Faker();
        String randomName = faker.name().firstName();
        System.out.println("randomName = " + randomName);

        String bodyString = "{\n" +
                "  \"name\"  : \" "+ randomName+"\",\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"phone\": 6234567890\n" +
                "}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyString)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201)
        .body("data.name",is(randomName))
                ;
    }
    @DisplayName("Posting with external json file")
    @Test
    public void testPostExternalFile(){
        File file1 = new File("spartan.json");
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(file1)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201)
                .body("data.name",is("From File"))
        ;


    }
    @DisplayName("Posting with Map object as body")
    @Test
    public void testPostWithMapAsBody(){
        Map<String, Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name","Vincent");
        bodyMap.put("gender", "Male");
        bodyMap.put("phone", 3476346789l);
        System.out.println("bodyMap = " + bodyMap);

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post("/spartans")
                .then()
                .log().all()
                .statusCode(201)
                .body("data.name", is("Vincent"))
        ;
    }
}
