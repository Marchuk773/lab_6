package ua.lviv.iot.matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextChecker {

    public static void checkPatterns(final int lengthOfWord, final String textToCheck) {
        Pattern secondPattern = Pattern.compile("\\w++");
        Pattern replaceQuestionmarkPattern = Pattern.compile("\\?");
        Matcher replaceQuestionmarkMatcher = replaceQuestionmarkPattern.matcher(textToCheck);
        Pattern firstPattern = Pattern.compile("[.?!](\\s|\\w)+\\?");
        Matcher firstMatcher = firstPattern
                .matcher("." + replaceQuestionmarkMatcher.replaceAll("?."));
        while (firstMatcher.find()) {
            Matcher secondMatcher = secondPattern.matcher(firstMatcher.group());
            while (secondMatcher.find()) {
                if (secondMatcher.group().length() == lengthOfWord) {
                    System.out.println(secondMatcher.group());
                }
            }
        }
    }

    public static int scanInt() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        return (int) scanner.nextInt();
    }

    public static String scanString() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}