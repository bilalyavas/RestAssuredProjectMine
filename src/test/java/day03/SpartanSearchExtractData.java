package day03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class SpartanSearchExtractData {


        @BeforeAll
        public static void init(){
            RestAssured.baseURI = "http://54.162.37.32";
            RestAssured.port = 8000;
            RestAssured.basePath = "/api";
        }

        @DisplayName("Deneme")
    @Test
    public void test1(){
            Response response = given()
                    .log().all()
                    .queryParam("gender","Female")
                    .when()
                    .get("/spartans/search")
                    .prettyPeek();

            JsonPath jp = response.jsonPath();

            int numOfFemaleSpartans = jp.getInt("numberOfElements");
            System.out.println("numOfFemaleSpartans = " + numOfFemaleSpartans);


            List<Integer> numList = jp.getList("content.id");
            System.out.println("numList = " + numList);
            List<String> nameList = jp.getList("content.name");
            System.out.println("nameList = " + nameList);


        }



}
