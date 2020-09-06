package day01;

import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcherComposer;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.AbstractDocument;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestAssuredMethodChaining {

    @DisplayName("First Attempt for chaining")
    @Test
    public void chainingMethodsTest1() {
        //given().
        //when()
        //then().
        //   "http://54.174.216.245:8000/api/hello"
        when().get("http://54.174.216.245:8000/api/hello").then().statusCode(200).header("Content-Length", "17");

        when().get("http://54.174.216.245:8000/api/hello").then().statusCode(is(200)).
                header("Content-Length", equalTo("17"));


    }

    @DisplayName("Using Hamcrest matcher for assertion")
    @Test

    public void testingWithMatcher() {


        when().get("http://54.174.216.245:8000/api/hello").
                prettyPeek().then()
                .statusCode(is(200))
                .header("Content-Length", equalTo("17")).
                header("Content-Type", "text/plain;charset=UTF-8").body(is("Hello from Sparta"))
        ;



    }
    @DisplayName("Testing gET /api/Spartans endpoint")
    @Test
    public void testAllSpartans(){
        given().
                header("Accept", "application/xml").
    when().get("http://54.174.216.245:8000/api/spartans").
    prettyPeek().
            then().statusCode(is(200));
    }
}