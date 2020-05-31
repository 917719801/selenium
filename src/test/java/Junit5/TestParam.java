package Junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestParam {
    @ParameterizedTest
    @ValueSource(ints = {1 , 2, 3})
    void testWithValueSource(int argument){
        assertTrue( argument>0 && argument < 4);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" ","    ","\t","\n"})
    void nullEmptyAndBlankString(String text){
        assertTrue(text == null || text.trim().isEmpty());
    }



}


