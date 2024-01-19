// tests by een#6495 on Discord
// but, I (Devin) rewrote them to demonstrate JUnit 5 features for ParameterizedTest, ValueSource, CsvSource, and MethodSource
// these features are very powerful, and super useful to learn for your future work experiences

// Sources:
// https://www.baeldung.com/parameterized-tests-junit-5
// https://mikemybytes.com/2021/10/19/parameterize-like-a-pro-with-junit-5-csvsource/

package a1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import a1.LargeInt;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

public class LargeIntEenParameterizedTest {
    @ParameterizedTest(name = "{index} test instantiation with value {0}")
    @ValueSource(strings = {"2994", "-42892543", "8403539391", "-30"})
    void testToStringValues(String value) {
        LargeInt me = new LargeInt(value);
        assertEquals(value, me.toString());
    }

    @ParameterizedTest(name = "{index} test that {0} + {1} = {2}")
    @CsvSource({
            "2048,8003453,8005501",
            "52492,73485,125977",
            "-900234,83852,-816382",
            "-8887,-234,-9121",
            "12314,454523,466837",
            "466837,7653,474490",
            "222,222,444"
    })
    void testAddition(String valueOne, String valueTwo, String expected) {
        LargeInt me = new LargeInt(valueOne);
        LargeInt me2 = new LargeInt(valueTwo);
        LargeInt me3 = me.add(me2);
        assertEquals(expected, me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(valueOne, me.toString().replace("+","").replace(",", ""));
        assertEquals(valueTwo, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testMultiAdd() {
        String valueOne = "12314";
        String valueTwo = "454523";
        String valueThree = "7653";
        LargeInt me = new LargeInt(valueOne);
        LargeInt me2 = new LargeInt(valueTwo);
        LargeInt me3 = me.add(me2);
        assertEquals("466837", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(valueOne, me.toString().replace("+","").replace(",", ""));
        assertEquals(valueTwo, me2.toString().replace("+","").replace(",", ""));
        LargeInt me4 = new LargeInt(valueThree);
        LargeInt me5 = me3.add(me4);
        assertEquals("474490", me5.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals("466837", me3.toString().replace("+","").replace(",", ""));
        assertEquals(valueThree, me4.toString().replace("+","").replace(",", ""));
    }

    // the MethodSource way is extremely useful if you want to have parameters of different types

    private static Stream<Arguments> subtractionValues() {
        return Stream.of(
                Arguments.of("5034534", "2343453", "2691081"),
                Arguments.of("54252492", "73485", "54179007"),
                Arguments.of("234", "83852", "-83618"),
                Arguments.of("-8887", "-234", "-8653"),
                Arguments.of("12314", "454523", "-442209"),
                Arguments.of("-442209", "7653", "-449862"),
                Arguments.of("45634", "83852", "-38218"),
                Arguments.of("-3453", "93853", "-97306"),
                Arguments.of("123204", "-123204", "246408"),
                Arguments.of("-123204", "-123204", "0")
        );
    }

    @ParameterizedTest(name = "{index} test that {0} - {1} = {2}")
    @MethodSource("subtractionValues")
    void testSubtraction(String valueOne, String valueTwo, String expected) {
        LargeInt me = new LargeInt(valueOne);
        LargeInt me2 = new LargeInt(valueTwo);
        LargeInt me3 = me.subtract(me2);
        assertEquals(expected, me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(valueOne, me.toString().replace("+","").replace(",", ""));
        assertEquals(valueTwo, me2.toString().replace("+","").replace(",", ""));
    }

    @Test
    void testMultiSubtract() {
        String valueOne = "12314";
        String valueTwo = "454523";
        String valueThree = "7653";
        LargeInt me = new LargeInt(valueOne);
        LargeInt me2 = new LargeInt(valueTwo);
        LargeInt me3 = me.subtract(me2);
        assertEquals("-442209", me3.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals(valueOne, me.toString().replace("+","").replace(",", ""));
        assertEquals(valueTwo, me2.toString().replace("+","").replace(",", ""));
        LargeInt me4 = new LargeInt(valueThree);
        LargeInt me5 = me3.subtract(me4);
        assertEquals("-449862", me5.toString().replace("+","").replace(",", ""));
        // ensure original LargeInts state didn't change
        assertEquals("-442209", me3.toString().replace("+","").replace(",", ""));
        assertEquals(valueThree, me4.toString().replace("+","").replace(",", ""));
    }
}