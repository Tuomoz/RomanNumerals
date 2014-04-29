import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import romannumerals.RomanNumeralsConverter;

/**
 * A test suite for the RomanNumeralsConverter class.
 * @author Tuomo Kärkkäinen
 */
public class RomanNumeralsConverterTest
{
    private RomanNumeralsConverter converter;
    
    @Before
    public void setUp()
    {
        converter = new RomanNumeralsConverter();
    }
    
    @Test
    public void testSigleLetters() {
        assertEquals(1, converter.convert("I"));
        assertEquals(10, converter.convert("X"));
        assertEquals(50, converter.convert("L"));
        assertEquals(100, converter.convert("C"));
        assertEquals(500, converter.convert("D"));
        assertEquals(1000, converter.convert("M"));
    }
    
    @Test
    public void testTwoSameLetters() {
        assertEquals(2, converter.convert("II"));
        assertEquals(200, converter.convert("CC"));
    }
    
    @Test
    public void testThreeSameLetters() {
        assertEquals(3, converter.convert("III"));
        assertEquals(3000, converter.convert("MMM"));
    }
    
    @Test
    public void testVI() {
        assertEquals(6, converter.convert("VI"));
    }
    
    @Test
    public void testIV() {
        assertEquals(4, converter.convert("IV"));
    }
    
    @Test
    public void testLXI() {
        assertEquals(61, converter.convert("LXI"));
    }
    
    @Test
    public void testMMXIV() {
        assertEquals(2014, converter.convert("MMXIV"));
    }
    
    @Test
    public void testLowerCase() {
        assertEquals(55, converter.convert("lv"));
    }
    
    @Test
    public void testRandomCase() {
        assertEquals(1066, converter.convert("mLxvI"));
    }
    
    @Test
    public void testEmptyString() {
        assertEquals(0, converter.convert(""));
    }
    
    @Test
    public void testRandomCharacters() {
        assertEquals(-1, converter.convert("asd123"));
    }
    
    @Test
    public void testOneWrongCharacter() {
        assertEquals(-1, converter.convert("IV."));
    }
}
