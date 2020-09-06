package day03;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ExtractingDataUsingJsonPathMethod {
@DisplayName("Getting")
    @Test
    public void test2(){
    Response response=
            given()
                    .log().all()
                   // .baseUri("http://www.omdbapi.com")
                    .queryParam("apikey", "26aa5b74")
                    .queryParam("t","Boss Baby")
                    .when()
                    .get("http://www.omdbapi.com");


    JsonPath jp=  response.jsonPath();

    String title = jp.getString("Title");
    int year = jp.getInt("Year");

    System.out.println(title);
    System.out.println(year);
    String director = jp.getString("Director");
    System.out.println(director);

    String ratingSrc = jp.getString("Ratings[0].Source");
    System.out.println(ratingSrc);
    System.out.println("========================");
    Map<String,Object> responseMap = jp.getMap("");
    System.out.println("responseMap = "+responseMap);
    System.out.println("Awards are :" + responseMap.get("Awards"));
    Map<String, Object> firstRatingMap = jp.getMap("Ratings[0]");
    System.out.println("firstRatingMap = " + firstRatingMap);

//   Map<String, Object> manuallyMap = new HashMap<>();
 //  manuallyMap.put

    List<String> sourceList = jp.getList("Ratings.Source");
    System.out.println("sourceList = " + sourceList);


}

}
