import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;



@RunWith(JMockit.class)
public class NumberToWordTest {
	NumberToWord numberToWord=new NumberToWord();

    @Test
    public void testEmptyString() throws SQLException {
    	
    	String result = numberToWord.convert("");

    	assertTrue(result.equals("Please enter an input"));
    }
    @Test
    public void testAlphaNumeric() throws SQLException {
    	
    	String result = numberToWord.convert("abcd123");

    	assertTrue(result.equals("Not an Number"));
    }
    @Test
    public void testFloatingNumber() throws SQLException {
    	
    	String result = numberToWord.convert("123.456");

    	assertTrue(result.equals("Not an Number"));
    }
    @Test
    public void testLargeNumber() throws SQLException {
    	
    	String result = numberToWord.convert("9999999999");

    	assertTrue(result.equals("please enter number below 999999999"));
    }
    @Test
    public void testZero() throws SQLException {
    	
    	String result = numberToWord.convert("0");

    	assertTrue(result.equals("zero"));
    }
    @Test
    public void testNumberToName() throws SQLException {
    	
    	String result = numberToWord.convert("123456789");

    	assertTrue(result.equals("one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine"));
    }
    @Test
    public void testNegitiveNumber() throws SQLException {
    	
    	String result = numberToWord.convert("-123456789");

    	assertTrue(result.equals("negative one hundred and twenty three million four hundred and fifty six thousand seven hundred and eighty nine"));
    }
}
