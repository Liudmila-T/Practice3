package ua.nure.timoshenko.practice3;


import java.util.HashMap;
import java.util.Map;


public final class Part5 {

    private static final String[] ROMAN_SYMBOLS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] DECIMAL_SYMBOLS = {1, 4, 5, 9, 10, 40, 50, 90, 100};

    private Part5() {
        super();
    }

    public static String decimal2Roman(int x) {
        StringBuilder result = new StringBuilder();

        for (int i = ROMAN_SYMBOLS.length - 1; i >= 0; i--) {

            while (x >= DECIMAL_SYMBOLS[i]) {
                result.append(ROMAN_SYMBOLS[i]);
                x -= DECIMAL_SYMBOLS[i];
            }
        }
        return result.toString();
    }

    public static int roman2Decimal(String s) {
        Map<String, Integer> romanToDecimal = new HashMap<>();
        for (int i = ROMAN_SYMBOLS.length - 1; i >= 0; i--) {
            romanToDecimal.put(ROMAN_SYMBOLS[i], DECIMAL_SYMBOLS[i]);
        }
        int result = 0;
        int top = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanToDecimal.get(String.valueOf(s.charAt(i)));
            if (value < top) {
                result -= value;
            } else {
                result += value;
                top = value;
            }
        }

        return result;
    }
}


