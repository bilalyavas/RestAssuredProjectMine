package day05;

import groovy.json.JsonOutput;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Spartan;
import pojo.Spartan2;

import java.util.List;

import static io.restassured.RestAssured.*;

public class JsonToPOJO_Practice {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.160.106.84";
        RestAssured.port= 8000;
        RestAssured.basePath="/api";


    }
    @DisplayName("json to POGO GET /spartan/{id}")
    @Test
    public void testSpartanJsonToSpartanObject(){
    int newID =SecureSpartanTest.createRandomSpartan();
        Response  response = given()
                .auth().basic("admin", "admin")
                .log().all()
                .pathParam("id", newID )
                .when()
                .get("/spartans/{id}")
                .prettyPeek();

        Spartan2 sp = response.as(Spartan2.class);
        //Spartan2 sp = new Spartan2()
        System.out.println("sp = " + sp);
    }

    @DisplayName("Search Request and save1st Request as Spartan2 Pojo")
    @Test
    public void gettingNestedJsonAsPojo(){
       Response response =  given()
                .log().all()
               .auth().basic("admin", "admin")
                .queryParam("gender","Male")
                .when()
                .get("/spartans/search")
                .prettyPeek();

        System.out.println("response.statusCode = " + response.statusCode());

        JsonPath jp= response.jsonPath();
        System.out.println("First id" + jp.getInt( "content[0].id"));

        System.out.println("First guy Name" + jp.getString("content[0].name"));

        Spartan2 firstMaleSpartan = jp.getObject("content[0]", Spartan2.class);
        System.out.println("firstMaleSpartan = " + firstMaleSpartan);

        System.out.println("The Spartan id from POJO is "+   firstMaleSpartan.getId());
        System.out.println("The Spartan name from POJO is "+firstMaleSpartan.getName());
        System.out.println("The Spartan gender from POJO is "+firstMaleSpartan.getGender());
        System.out.println("The Spartan phone from POJO is "+firstMaleSpartan.getPhone());

    }
    @DisplayName("Save the jsonarray as List<Spartan")
    @Test
            public void testList(){

        Response response = given()
                .auth().basic("admin","admin")
                .queryParam("gender", "Female")
                .when()
                .get("/spartans/search");

        JsonPath jp = response.jsonPath();
        List<Integer> ids = jp.getList("content.id");
        System.out.println(ids);

        List<String> names = jp.getList("content.name");
        System.out.println(names);

        List<Spartan2> spartan2List = jp.getList("content", Spartan2.class);
        System.out.println("spartan2List = " + spartan2List);

     //   for (Spartan2 each :spartan2List){
      //      System.out.println(each);
       // }
        spartan2List.forEach(each-> System.out.println(each));

    }



}

