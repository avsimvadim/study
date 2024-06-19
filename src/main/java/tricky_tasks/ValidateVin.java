package tricky_tasks;

import java.util.*;

public class ValidateVin {
    
    //Test
    public static void main(String[] args) {
        String correctVin = "2C3CDXCT6EH183170";
        System.out.println(isValidVIN(correctVin));

        String incorrectVin = "2C3CDXCT6EH183470";
        System.out.println(isValidVIN(incorrectVin));
    }

    //initialization
    //weights of each symbol in VIN
    //It's predetermined
    private static final int[] WEIGHTS = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};
    //map ot the symbols and their corresponding digits
    //It's also predetermined
    private static final Map<Character, Integer> CHAR_VALUES = new HashMap<>();

    static {
        CHAR_VALUES.put('0', 0);
        CHAR_VALUES.put('1', 1);
        CHAR_VALUES.put('2', 2);
        CHAR_VALUES.put('3', 3);
        CHAR_VALUES.put('4', 4);
        CHAR_VALUES.put('5', 5);
        CHAR_VALUES.put('6', 6);
        CHAR_VALUES.put('7', 7);
        CHAR_VALUES.put('8', 8);
        CHAR_VALUES.put('9', 9);
        CHAR_VALUES.put('A', 1);
        CHAR_VALUES.put('B', 2);
        CHAR_VALUES.put('C', 3);
        CHAR_VALUES.put('D', 4);
        CHAR_VALUES.put('E', 5);
        CHAR_VALUES.put('F', 6);
        CHAR_VALUES.put('G', 7);
        CHAR_VALUES.put('H', 8);
        CHAR_VALUES.put('J', 1);
        CHAR_VALUES.put('K', 2);
        CHAR_VALUES.put('L', 3);
        CHAR_VALUES.put('M', 4);
        CHAR_VALUES.put('N', 5);
        CHAR_VALUES.put('P', 7);
        CHAR_VALUES.put('R', 9);
        CHAR_VALUES.put('S', 2);
        CHAR_VALUES.put('T', 3);
        CHAR_VALUES.put('U', 4);
        CHAR_VALUES.put('V', 5);
        CHAR_VALUES.put('W', 6);
        CHAR_VALUES.put('X', 7);
        CHAR_VALUES.put('Y', 8);
        CHAR_VALUES.put('Z', 9);
    }

    public static boolean isValidVIN(String vin) {
        //basic check for the rules applied to VIN
        if (vin == null || vin.length() != 17 || !vin.matches("[A-HJ-NPR-Z0-9]{17}")) {
            return false;
        }

        // Calculate the check digit
        // Sum af all the digits that correspond to their vin symbol, multiplied by the weight of their position in the VIN
        // Symbol N9 is the check digit itself so it's weight is 0
        int checkSum = 0;
        for (int i = 0; i < 17; i++) {
            Optional<Integer> optionalValue = Optional.ofNullable(CHAR_VALUES.get(vin.charAt(i)));
            if (!optionalValue.isPresent()) {
                return false; // Invalid character
            }
            checkSum += optionalValue.get() * WEIGHTS[i];
        }

        // Determine the expected check digit
        // Finding the reminder of % 11. Part of a predetermined algorithm
        int checkDigitValue = checkSum % 11;
        // If check digit calculated is 10 than we correspond it to letter 'X'
        char expectedCheckDigit = (checkDigitValue == 10) ? 'X' : Character.forDigit(checkDigitValue, 10);

        // Compare the calculated check digit to the actual check digit
        return vin.charAt(8) == expectedCheckDigit;
    }
}
