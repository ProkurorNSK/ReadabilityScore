import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) - string.charAt(i - 1) != 1) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
