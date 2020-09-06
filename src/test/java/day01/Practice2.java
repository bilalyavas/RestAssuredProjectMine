package day01;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Practice2 {
    @Test
    public void test1(){
    int num1 = 5;
    int num2 = 4;

    assertThat(num1 +num2 , is(9));
    assertThat(num1+num2 , equalTo(9));
    assertThat(num1+num2 , not(11));
    assertThat(num1+num2 , is(not(11)));

    String firstName = "Kaisar";
    String lastName = "Anvar";
    assertThat( firstName +lastName , is("Kaisar Anvar"));
    assertThat(firstName+lastName, equalTo("Kaisar Anvar"));
    assertThat(firstName+lastName , is(equalTo("Kaisar Anvar")));
    assertThat(firstName, equalToIgnoringCase("kaisar"));

    assertThat(firstName, equalToCompressingWhiteSpace("Kaisar"));



    }
    @DisplayName("Support for collection")
    @Test
    public void test2(){
        List<Integer>numList = Arrays.asList(11,44,3,55,88,5);
        assertThat(numList, hasSize(6));

        assertThat(numList, hasItem(11));
        assertThat(numList, hasItems(3,44,55));
        assertThat(numList, containsInAnyOrder(11, 55, 44,3,88,5));
    }




}
