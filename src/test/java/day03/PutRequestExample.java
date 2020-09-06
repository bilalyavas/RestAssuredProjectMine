package day03;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.naming.directory.SchemaViolationException;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PutRequestExample {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.162.37.32";
        RestAssured.port = 8000;
        RestAssured.basePath = "/api";
    }
    @DisplayName("Updating existing Data")
    @Test
    public void updataSpaartan(){
        String updatedBody="{\n" +
                "    \"id\" : 17 , \n" +
                "    \"name\" : \"This Worker!\",\n" +
                "    \"gender\" : \"Female\",\n" +
                "    \"phone\" : 9876543210\n" +
                "}" ;
        given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .log().all()
                .when()
                .put("/spartans/{id}",17)
                .then()
                .log().all()
                .statusCode(204)
                ;
}
@Test
    public void testDelete(){
     when()
             .get("/spartans/{id}",17)
             .then()
     .statusCode(204)
     .body(is(empty()))
             ;
}
}
