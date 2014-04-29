package romannumerals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A class for converting Roman numerals to integers.
 * @author Tuomo Kärkkäinen
 */
public class RomanNumeralsConverter
{
    // Map containing integer values for the matching Roman letters
    private static final Map<Character, Integer> numberMap;

    static {
        Map<Character, Integer> numberMapSource = new HashMap<>();
        numberMapSource.put('I', 1);
        numberMapSource.put('V', 5);
        numberMapSource.put('X', 10);
        numberMapSource.put('L', 50);
        numberMapSource.put('C', 100);
        numberMapSource.put('D', 500);
        numberMapSource.put('M', 1000);
        numberMap = Collections.unmodifiableMap(numberMapSource);
    }

    /**
     * The method for converting a given Roman number into an integer. It accepts
     * strange letter combinations like VC (95) which should be written like XCV.
     * 
     * @param romanNumber The Roman number to be converted. The case of the letters
     * doesn't matter.
     * @return Returns the converted integer value. If the string contains characters
     * that don't exist in the Roman number letters -1 is returned.
     */
    public int convert(String romanNumber) {
        if (romanNumber.length() == 0) {
            return 0;
        }

        romanNumber = romanNumber.toUpperCase();
        char[] letters = romanNumber.toCharArray();
        int sum = 0;

        // Go through all the characters in the given string from left to right.
        // The current number is compared to the next one for the subtraction rule
        for (int i = 0; i < letters.length; i++) {
            int currentNum = letterToInt(letters[i]);
            // If the next number index would be out of bounds use the value 0
            int nextNum = (i + 1 < letters.length) ? letterToInt(letters[i + 1]) : 0;
            // If either letter was not a number stop the conversion
            if (currentNum == -1 || nextNum == -1) {
                sum = -1;
                break;
            }

            // If the current number was smaller than the next, we have to subtract them
            // and hop over the next number to not add it again
            if (currentNum >= nextNum) {
                sum += currentNum;
            } else {
                sum += nextNum - currentNum;
                i++;
            }
        }
        return sum;
    }

    /**
     * A method to convert a single Roman letter into an integer.
     * @param letter The letter to be converted.
     * @return Returns the matching integer. If the given character doesn't exist 
     * in the Roman number letters return -1.
     */
    private int letterToInt(char letter) {
        Integer number = numberMap.get(letter);
        if (number == null) {
            return -1;
        } else {
            return number;
        }
    }
}
