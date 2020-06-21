package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String text = new String(Files.readAllBytes(Paths.get(args[0])));

        int countSentences = text.split("[.?!]").length;
        int countCharacters = text.split("[\\S]", -1).length - 1;
        int countSyllables = 0;
        int countPolysyllables = 0;

        String[] words = text.split("\\s+");
        int countWords = words.length;


        for (String word : words) {
            String wordClear = word.replaceFirst("\\W$+", "").replaceFirst("e$", "");
            String[] syllables = wordClear.split("[aeiouyAEIOUY]+", -1);
            int cSyllables = Math.max(syllables.length - 1, 1);
            countSyllables += cSyllables;
            if (cSyllables > 2) {
                countPolysyllables++;
            }
        }

        System.out.printf("Words: %d\n", countWords);
        System.out.printf("Sentences: %d\n", countSentences);
        System.out.printf("Characters: %d\n", countCharacters);
        System.out.printf("Syllables: %d\n", countSyllables);
        System.out.printf("Polysyllables: %d\n", countPolysyllables);

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String answer = scanner.next();
        System.out.println();

        double score;
        int age;
        switch (answer) {
            case "ARI":
                score = getARI(countSentences, countCharacters, countWords);
                age = getAge(score);
                System.out.printf("Automated Readability Index: %.2f (about %d year olds).\n", score, age);
                break;
            case "FK":
                score = getFK(countSentences, countSyllables, countWords);
                age = getAge(score);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).\n", score, age);
                break;
            case "SMOG":
                score = getSMOG(countSentences, countPolysyllables);
                age = getAge(score);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).\n", score, age);
                break;
            case "CL":
                score = getCL(countSentences, countCharacters, countWords);
                age = getAge(score);
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds).\n", score, age);
                break;
            case "all":
                int averageAge = 0;

                score = getARI(countSentences, countCharacters, countWords);
                age = getAge(score);
                System.out.printf("Automated Readability Index: %.2f (about %d year olds).\n", score, age);
                averageAge += age;

                score = getFK(countSentences, countSyllables, countWords);
                age = getAge(score);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).\n", score, age);
                averageAge += age;

                score = getSMOG(countSentences, countPolysyllables);
                age = getAge(score);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).\n", score, age);
                averageAge += age;

                score = getCL(countSentences, countCharacters, countWords);
                age = getAge(score);
                System.out.printf("Coleman–Liau index: %.2f (about %d year olds).\n", score, age);
                averageAge += age;

                System.out.printf("\nThis text should be understood in average by %.2f year olds.", (double) averageAge / 4);
        }
    }

    private static double getARI(int countSentences, int countCharacters, int countWords) {
        return 4.71 * ((double) countCharacters / countWords) + 0.5 * ((double) countWords / countSentences) - 21.43;
    }

    private static double getFK(int countSentences, int countSyllables, int countWords) {
        return 0.39 * ((double) countWords / countSentences) + 11.8 * ((double) countSyllables / countWords) - 15.59;
    }

    private static double getSMOG(int countSentences, int countPolysyllables) {
        return 1.043 * Math.sqrt((double) countPolysyllables * 30 / countSentences) + 3.1291;
    }

    private static double getCL(int countSentences, int countCharacters, int countWords) {
        return 0.0588 * ((double) countCharacters / countWords * 100) - 0.296 * ((double) countSentences / countWords * 100) - 15.8;
    }

    private static int getAge(double score) {
        int scoreAge = (int) Math.round(score);
        int age;
        if (scoreAge < 3) {
            age = scoreAge + 5;
        } else if (scoreAge < 13) {
            age = scoreAge + 6;
        } else {
            age = scoreAge + 11;
        }
        return age;
    }
}