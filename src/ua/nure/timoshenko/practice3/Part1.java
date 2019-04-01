package ua.nure.timoshenko.practice3;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Part1 {

    private static final String ARROW = " ==> ";
    private static final String SEMICOLON = ";";
    private static final String COMMA = ",";

    private static final String LOGIN = "login";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String E_MAIL = "email";
    private static final String DOMAIN = "domain";
    private static final String ALL_STRING = "allString";

    private static final String REGEX =
            "(?m)^(?<" + LOGIN + ">.+);(?<" + FIRST_NAME + ">.+) (?<" + LAST_NAME + ">.+);" +
                    "(?<" + E_MAIL + ">.+@(?<" + DOMAIN + ">.+))$";

    private static final int START_RANDOM = 1000;
    private static final int END_RANDOM = 9999;

    private Part1() {
        super();
    }

    public static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result.append(matcher.group(LOGIN)).append(ARROW).
                    append(matcher.group(E_MAIL)).append(System.lineSeparator());
        }
        return result.toString();
    }

    public static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            result.append(matcher.group(LAST_NAME)).append(" ").append(matcher.group(FIRST_NAME)).
                    append(" (").append(E_MAIL).append(": ").append(matcher.group(E_MAIL)).append(")").
                    append(System.lineSeparator());
        }
        return result.toString();
    }

    public static String convert3(String input) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        HashMap<String, StringBuilder> hashMap = new LinkedHashMap<>();
        while (matcher.find()) {
            if (hashMap.containsKey(matcher.group(DOMAIN))) {
                hashMap.put(matcher.group(DOMAIN),
                        hashMap.get(matcher.group(DOMAIN)).append(matcher.group(LOGIN)).append(COMMA).append(" "));
            } else {
                StringBuilder value = new StringBuilder();
                hashMap.put(matcher.group(DOMAIN), value.append(matcher.group(LOGIN)).append(COMMA).append(" "));
            }
        }
        for (Map.Entry<String, StringBuilder> entry : hashMap.entrySet()) {
            result.append(entry.getKey()).append(ARROW).append(entry.getValue());
            result.replace(result.lastIndexOf(COMMA), result.lastIndexOf(COMMA) + 2, System.lineSeparator());
        }
        return result.toString();
    }

    public static String convert4(String input) {
        int counter = 0;
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("(?m)^(?<" + ALL_STRING + ">.+)$");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            counter++;
            if (counter == 1) {
                result.append(matcher.group(ALL_STRING)).append(SEMICOLON).
                        append("Password").append(System.lineSeparator());
            } else {
                Random random = new SecureRandom();
                int randomInt = START_RANDOM + random.nextInt(END_RANDOM - START_RANDOM);
                result.append(matcher.group(ALL_STRING)).append(SEMICOLON).
                        append(randomInt).append(System.lineSeparator());
            }
        }
        return result.toString();
    }


}

