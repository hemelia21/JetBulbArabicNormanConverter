import java.util.HashMap;
import java.util.Map;

public class NotationConverter {
    private static final Map<String, Integer> romanArabicConverter = new HashMap<>();
    private int arabicNotation;

    static {
        romanArabicConverter.put("I", 1);
        romanArabicConverter.put("V", 5);
        romanArabicConverter.put("X", 10);
        romanArabicConverter.put("L", 50);
        romanArabicConverter.put("C", 100);
        romanArabicConverter.put("D", 500);
        romanArabicConverter.put("M", 1000);
        romanArabicConverter.put("IV", 4);
        romanArabicConverter.put("IX", 9);
        romanArabicConverter.put("XL", 40);
        romanArabicConverter.put("XC", 90);
        romanArabicConverter.put("CD", 400);
        romanArabicConverter.put("CM", 900);
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
            String letter = romanNotation.substring(i, i + 1);
            String twoLetters = "";

            if (!romanArabicConverter.containsKey(letter)) {
                throw new InvalidValueException(
                        "InvalidValueException: String must contain only valid roman numerals [I, V, X, L, C, D, M]."
                );
            }
            if (i <  romanNotationLength - 1) {
                twoLetters = romanNotation.substring(i, i + 2);
            }
            if (romanArabicConverter.containsKey(twoLetters)) {
                    this.arabicNotation += romanArabicConverter.get(twoLetters);
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
