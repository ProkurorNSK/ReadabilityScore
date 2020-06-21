import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ax = scanner.nextDouble();
        double ay = scanner.nextDouble();

        double bx = scanner.nextDouble();
        double by = scanner.nextDouble();

        double ab = ax * bx + ay * by;
        double a = Math.hypot(ax, ay);
        double b = Math.hypot(bx, by);

        System.out.println(Math.toDegrees(Math.acos(ab / (a * b))));
    }
}