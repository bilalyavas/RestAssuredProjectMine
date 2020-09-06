package day01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class SampleTest {

   @Test
   public void calculatorTest(){
       System.out.println("hello World");
       assertEquals(9,4+5);


       //assertEquals(10,5+4, "Hey wrong");
   }
   @DisplayName("I am testing the name")
   @Test
   public void nameTest(){
       System.out.println("bilal"+ "yavas");
        String firstName= "bilal";
        String lastName= "yavas";
        assertEquals( "bilal yavas", firstName+" "+lastName);


   }
}
