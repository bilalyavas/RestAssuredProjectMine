package day03;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
public class ExtractingDataOutOfResponseBody {

    @DisplayName("Getting Movie info")
    @Test
    public void test1(){
        Response response=
                given()
                        .log().all()
                .baseUri("http://www.omdbapi.com")
                .queryParam("apikey", "26aa5b74")
                .queryParam("t","Boss Baby")
                .when()
                        .get("");
        System.out.println("------------------------");
        response.prettyPrint();
        System.out.println("==========================");
        response.prettyPeek();
        System.out.println(response.statusCode());
        System.out.println("+++++++++++++++++++++++++++++++==");
        String firstRatingSrc = response.path("Rating[0].Source");

        //String title = response.path("Title");
        //System.out.println("title :" + title);

        String director = response.path("Director");
        System.out.println("director : "+ director);
    }
}
