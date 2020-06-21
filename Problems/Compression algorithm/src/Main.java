import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        int count = 0;
        char character = ' ';
        for (int i = 0; i < line.length(); i++) {
            if (i == 0) {
                character = line.charAt(i);
                count++;
            } else if (line.charAt(i) == character) {
                count++;
            } else {
                result.append(character).append(count);
                character = line.charAt(i);
                count = 1;
            }
        }
        result.append(character).append(count);
        System.out.println(result.toString());
    }
}
