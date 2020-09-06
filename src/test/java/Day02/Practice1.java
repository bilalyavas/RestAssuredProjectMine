package Day02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Practice1 {
    @DisplayName("Get All Characters Simple Test")
@Test
    public void testBreakingBad(){
when().
        get("https://www.breakingbadapi.com/api/characters").
        prettyPeek().
        then().
        statusCode(is(200))

        //.header("Content-Type", "application/json; charset=utf-8")
        .header("Content-Type", is("application/json; charset=utf-8"))
;

}
}
