package ua.nure.timoshenko.practice3;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part2 {

    private static final String REGEX = "([A-zА-яїё]+)";

    private static int minLengthWord = Integer.MAX_VALUE;
    private static int maxLengthWord;

    private Part2() {
        super();
    }

    public static String convert(String input) {

        countMinMaxLengthWords(input);

        StringBuilder result = new StringBuilder();

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);

        Set<String> minWords = new LinkedHashSet<>();
        Set<String> maxWords = new LinkedHashSet<>();

        while (matcher.find()) {
            if (matcher.group().length() == minLengthWord) {
                minWords.add(matcher.group());
            }
            if (matcher.group().length() == maxLengthWord) {
                maxWords.add(matcher.group());
            }
        }
        result.append("Min: ");
        iterator(result, minWords.iterator());
        result.delete(result.length() - 2, result.length()).append(System.lineSeparator());

        result.append("Max: ");
        iterator(result, maxWords.iterator());
        result.delete(result.length() - 2, result.length()).append(System.lineSeparator());

        return result.toString();
    }

    private static void iterator(StringBuilder sb, Iterator i) {
        while (i.hasNext()) {
            sb.append(i.next()).append(", ");
        }
    }


    public static void countMinMaxLengthWords(String text) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group().length() < minLengthWord) {
                minLengthWord = matcher.group().length();
            }
            if (matcher.group().length() > maxLengthWord) {
                maxLengthWord = matcher.group().length();
            }
        }
    }
}
