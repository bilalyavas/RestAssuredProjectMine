package Day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class ZipCodeTest {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://api.zippopotam.us";
        RestAssured.basePath = "/us";
    }
    @DisplayName("Zip to city Test")
    @Test
    public void ZipCodeTest(){
        //RestAssured.baseURI="api.zippopotam.us/us";
        //RestAssured.basePath= "/:zipcode";
        given()

                .pathParam("zip","22030")
                .log().all()
                .when()
                .get("/{zip}")
                .then()
                .log().all()
                .statusCode(is(200))
        .contentType(ContentType.JSON)
        .body("country",is("United States"))
        .body("places[0].state",is("Virginia"))
        .body("'post code'", is("22030"))
        .body("places[0][\"place name\"]", is("Fairfax"))
        ;

    }
    @DisplayName("City to Zip")
    @Test
    public void CityCodeTest(){
        //given()
                //.pathParam("state", "VA")
               // .pathParam("city","Fairfax")
               // .log().all()
                when()
                .get("{state}/{city}","VA","Fairfax")
                .then()
                .log().all()
                .statusCode(is(200))
                .body("'country abbreviation'",is("US"))
                .body("places[0].latitude",is("38.8458"))
                .body("places[-1].latitude", is("38.7602"))
                //.body("places[9].latitude", is("38.7602"))


        ;


    }
}
