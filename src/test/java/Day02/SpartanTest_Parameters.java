package Day02;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;;
public class SpartanTest_Parameters {


  @BeforeAll
  public static void setUp(){
      RestAssured.baseURI= "http://54.162.37.32:8000";
      RestAssured.basePath = "/api";
  }
   @DisplayName("Testing /Spartans/{id}")
   @Test
   public void testSingleSpartan(){

     given()
     .log().all()
             .pathParam("id", 17)
             .when()
             .get("spartans/{id}").
             then().statusCode(is(200));
   }

    @DisplayName("Testing2 /Spartans/{id}")
    @Test
    public void testSingleSpartan2(){

        given()
                .log().all()
                .when()
                .get("spartans/{id}", 17).
                then().statusCode(is(200));
    }


    @DisplayName("Testing /spartans{id} Body")
    @Test
    public void testSingleSpartanBody(){

      given()
              .log().all()
              .pathParam("id",17)
              .when()
              .get("spartans/{id}")
              .then()
              .log().all()
              .statusCode(is(200))
      //.body("Json Path", is("The Value"))
      .body("id",is(17))
      .body("name",is("abc"))
      .body("gender",is("Female"))
      .body("phone",is(9876543210L))
      ;


    }


}
