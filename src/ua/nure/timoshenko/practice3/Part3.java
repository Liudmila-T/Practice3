package ua.nure.timoshenko.practice3;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part3 {

    private static final String FIRST_LETTER = "firstLetter";
    private static final String WORD = "word";

    private static final String REGEX = "(?<" + FIRST_LETTER + ">[A-zА-яїё]{1})(?<" + WORD + ">\\S{2,}\\s?)";

    private Part3() {
        super();
    }

    public static String convert(String input) {
        StringBuffer result = new StringBuffer();

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(FIRST_LETTER).toUpperCase(Locale.getDefault()));
            result.append(matcher.group(WORD));
        }
        matcher.appendTail(result);

        return result.toString();
    }

}
