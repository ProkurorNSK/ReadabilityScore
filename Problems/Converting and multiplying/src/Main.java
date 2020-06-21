import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!(line = scanner.nextLine()).equals("0")) {
            try {
                System.out.println(Integer.parseInt(line) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + line);
            }
        }
    }
}