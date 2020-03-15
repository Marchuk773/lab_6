package ua.lviv.iot.matcher;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextChecker {

    public static void checkPatterns(final int lengthOfWord, final String textToCheck) {
        Set<String> foundWords = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile("\\w++");
        Pattern replaceQuestionmarkPattern = Pattern.compile("\\?");
        Matcher replaceQuestionmarkMatcher = replaceQuestionmarkPattern.matcher(textToCheck);
        Pattern findQuestioningSentencesPattern = Pattern.compile("[.?!](\\s|\\w)+\\?");
        Matcher findQuestioningSentencesMatcher = findQuestioningSentencesPattern
                .matcher("." + replaceQuestionmarkMatcher.replaceAll("?."));
        while (findQuestioningSentencesMatcher.find()) {
            Matcher matcher = pattern.matcher(findQuestioningSentencesMatcher.group());
            while (matcher.find()) {
                if (matcher.group().length() == lengthOfWord) {
                    foundWords.add(matcher.group());
                }
            }
        }
        for (String foundWord : foundWords) {
            System.out.println(foundWord);
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