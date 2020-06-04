package testcase01.Junit5DemoTest;
/*
junit5标签初识
 */

import org.junit.jupiter.api.*;
@DisplayName("junit5标签显示")
public class Junit5Label {
    @BeforeAll
    public static void beforeall(){
        System.out.println("beforeall");
    }
    @BeforeEach
    void beforeeach(){
        System.out.println("beforeeach");
    }
    @Test
    @DisplayName("方法01")
    @RepeatedTest(5)
    void fun01(){
        System.out.println("fun01");
    }
    @Test
    @Disabled
    @DisplayName("方法02")
    void fun02(){
        System.out.println("fun02");
    }
    @AfterEach
    void aftereach(){
        System.out.println("aftereach");
    }
    @AfterAll
    public static void afterall(){
        System.out.println("afterall");
    }
}
