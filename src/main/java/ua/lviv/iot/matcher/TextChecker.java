package ua.lviv.iot.matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextChecker {

    public static void checkPatterns(final int lengthOfWord, String textToCheck) {
//        (^\\w{x}\\s)|(\\s\\w{x}\\s)
        String regularExpression = "\\w++";
        Pattern pattern2 = Pattern.compile(regularExpression);
        Pattern findQuestionsPattern = Pattern.compile("\\?");
        Matcher findQuestionsMatcher = findQuestionsPattern.matcher(textToCheck);
        Pattern pattern = Pattern.compile("[.?!](\\s|\\w)+\\?");
        Matcher matcher = pattern.matcher("." + findQuestionsMatcher.replaceAll("?."));
        while (matcher.find()) {
            
            Matcher matcher2 = pattern2.matcher(matcher.group());
            while (matcher2.find()) {
                if (matcher2.group().length() == lengthOfWord) {
                    System.out.println(matcher2.group());
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