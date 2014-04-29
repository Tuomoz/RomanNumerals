package romannumerals;

/**
 * An application for converting Roman numbers into integers. The program takes
 * a list of numbers to be converted as command line parameters.
 * 
 * @author Tuomo Kärkkäinen
 */
public class RomanNumerals
{

    public static void main(String[] args)
    {
        RomanNumeralsConverter converter = new RomanNumeralsConverter();
        if (args.length > 0) {
            for (String romanNumber : args) {
                int converted = converter.convert(romanNumber);
                if (converted != -1) {
                    System.out.println(romanNumber + " = " + converted);
                } else {
                    System.out.println(romanNumber + " is not a valid Roman number.");
                }
            }
        } else {
            System.out.println("Please give the numbers to be converted as command line parameters.");
        }
    }
    
}
