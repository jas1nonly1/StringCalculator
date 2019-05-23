package saini.jaspreet.stringcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StringCalculatorTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void emptyStringReturnsZeroValue(){
        assertEquals(0, MainActivity.add(""));
    }
    @Test
    public void sumOfThreeNumbersEnteredWithCommas(){
        assertEquals(1+2+3, MainActivity.add("1,2,3"));
    }
    @Test
    public void newLinesBetweenNumbersReturnTheirSum(){
        assertEquals(1+2+3, MainActivity.add("1\n,2,3"));
        assertEquals(1+2+4, MainActivity.add("1,\n2,4"));
    }
    @Test
    public void specifiedDelimiterWillSeparateNumbers(){
        assertEquals(1+3+4, MainActivity.add("//;\\n1;3;4"));
        assertEquals(2+3+8, MainActivity.add("//@\\n2@3@8"));
    }
}