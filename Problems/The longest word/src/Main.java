import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        String maxWord = "";
        for (String word: words) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }
        System.out.println(maxWord);
    }
}