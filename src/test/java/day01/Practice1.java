package day01;
import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcherComposer;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practice1 {

    //http://52.71.242.164:8000/api/hello

@Test
    public void test1(){
    //RestAssured.get("URL HERE")
   Response response = get("http://54.174.216.245:8000/api/hello");

    System.out.println("status code of this response :" +response.statusCode());
    System.out.println("getting status line of this response "+ response.statusLine());
    System.out.println("status code of this response :" + response.getStatusCode());

    System.out.println("Getting the value of date heater "+ response.header("Date"));
    System.out.println("Getting the value of date heater "+ response.getHeader("Date"));

    System.out.println("Content-Type header "+ response.header("Content-Type"));
    System.out.println("Content-Length header "+ response.header("Content-Length"));

    System.out.println(response.contentType());
    System.out.println(response.getContentType());

}
@DisplayName("Testing / Hello endpoint")
@Test
    public void  testHello(){
    Response response = get("http://54.174.216.245:8000/api/hello");
    assertEquals(200, response.statusCode());

    assertEquals("text/plain;charset=UTF-8", response.contentType());
    assertEquals("text/plain;charset=UTF-8", response.header("Content-Type"));

    assertEquals("text/plain;charset=UTF-8", response.getHeader("Content-Type"));

    System.out.println(response.contentType());
    System.out.println(response.getContentType());
    System.out.println(response.header("Content-Type"));
    assertEquals("17", response.header("Content-length"));



}
@DisplayName("Testing/hello endpoint body")
@Test
    public void testingHelloResponseBody(){
    Response response = get("http://54.174.216.245:8000/api/hello");
    System.out.println(response.asString());
    System.out.println(response.body());
    System.out.println(response.getBody());
    System.out.println(response.body().asString());
    System.out.println(response.getBody().asString());
    assertEquals("Hello from Sparta", response.asString());
    assertEquals("Hello from Sparta", response.body().asString());
    assertEquals("Hello from Sparta", response.getBody().asString());
    assertEquals(17, response.asString().length());
    String helloBody = response.asString();
    assertEquals(17 , helloBody.length());
    assertEquals("Hello from Sparta", helloBody);

}
@DisplayName("Printing the response body using method")
    @Test
    public void printingBody(){
    Response response = get("http://54.174.216.245:8000/api/hello");
    response.prettyPrint();
    System.out.println("=================================================");
    response.prettyPeek();

    System.out.println("++++++++++++++++++++++++++++++++++++++=");
    int statusCode = response.prettyPeek().statusCode();
    System.out.println("printing only status code :" +  statusCode);
}

}
