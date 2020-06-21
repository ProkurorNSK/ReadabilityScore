import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            for (char c : string.toCharArray()) {
                if (!Character.isDigit(c)) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}