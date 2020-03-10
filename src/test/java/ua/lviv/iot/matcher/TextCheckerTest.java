package ua.lviv.iot.matcher;

import org.junit.jupiter.api.Test;

class TextCheckerTest {

    @Test
    void checkPatternsTest() {
        System.out.println("Enter length of the word");
        int scannedNumber = TextChecker.scanInt();
        System.out.println("Enter text to check");
        String scannedText = TextChecker.scanString();
        TextChecker.checkPatterns(scannedNumber, scannedText);
    }

}