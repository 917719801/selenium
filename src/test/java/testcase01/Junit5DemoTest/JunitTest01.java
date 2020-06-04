package testcase01.Junit5DemoTest;
/*
Junit5对比断言
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitTest01 {
    @Test
    void assertion(){
        assertAll(
                () -> assertEquals(1,1),
                () -> assertEquals(1, 1),
                () -> assertEquals(1, 1)
        );
    }




}
