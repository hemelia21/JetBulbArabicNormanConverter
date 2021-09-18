import java.util.HashMap;
import java.util.Map;

public class NotationConverter {
    private static final Map<Character, Integer> romanArabicConverter = new HashMap<>();
    private static final Map<String, Integer> specialRomanArabicConverter = new HashMap<>();
    private int arabicNotation;

    static {
        romanArabicConverter.put('I', 1);
        romanArabicConverter.put('V', 5);
        romanArabicConverter.put('X', 10);
        romanArabicConverter.put('L', 50);
        romanArabicConverter.put('C', 100);
        romanArabicConverter.put('D', 500);
        romanArabicConverter.put('M', 1000);
        specialRomanArabicConverter.put("IV", 4);
        specialRomanArabicConverter.put("IX", 9);
        specialRomanArabicConverter.put("XL", 40);
        specialRomanArabicConverter.put("XC", 90);
        specialRomanArabicConverter.put("CD", 400);
        specialRomanArabicConverter.put("CM", 900);
    }

    public int toArabic(String romanNotation) throws InvalidValueException {
        int i = 0;
        int romanNotationLength = romanNotation.length();

        if (romanNotationLength == 0) {
            throw new InvalidValueException(
                    "InvalidValueException: String must contain only valid roman numerals [I, V, X, L, C, D, M]."
            );
        }

        while (i < romanNotationLength) {
            char letter = romanNotation.charAt(i);
            String twoLetters = "";

            if (!romanArabicConverter.containsKey(letter)) {
                throw new InvalidValueException(
                        "InvalidValueException: String must contain only valid roman numerals [I, V, X, L, C, D, M]."
                );
            }
            if (i <  romanNotationLength - 1) {
                twoLetters = romanNotation.substring(i, i + 2);
            }
            if (specialRomanArabicConverter.containsKey(twoLetters)) {
                    this.arabicNotation += specialRomanArabicConverter.get(twoLetters);
                    i++;
            }
            else {
                this.arabicNotation += romanArabicConverter.get(letter);
            }
            i++;
        }
        return this.arabicNotation;
    }
}
