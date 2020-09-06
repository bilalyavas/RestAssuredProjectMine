package day01;
import org.junit.jupiter.api.*;


public class BeforeAfterInJunit5 {

    @BeforeAll
public static void setUp(){
    System.out.println("This run before All");
}

@BeforeEach
public void beforeeachTest(){
    System.out.println("Running before the test");
}
@Test
    public void test1(){
        System.out.println("test1 is running");
}

//@Disabled
@Test
public void test2(){
    System.out.println("test2 is running");


}

@AfterEach
public void afterEachTest(){
    System.out.println("Running after the test");
}

@AfterAll
    public static void tearDown(){
    System.out.println("this run all the way at the end");
}


}
