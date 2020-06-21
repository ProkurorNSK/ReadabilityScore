import java.util.Arrays;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int[] numbers = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            numbers[i] = Integer.parseInt(args[i + 1]);
        }
        switch (operator) {
            case "MAX":
                System.out.println(Arrays.stream(numbers).max().orElse(0));
                break;
            case "MIN":
                System.out.println(Arrays.stream(numbers).min().orElse(0));
                break;
            case "SUM":
                System.out.println(Arrays.stream(numbers).sum());
                break;
            default:
        }
    }
}