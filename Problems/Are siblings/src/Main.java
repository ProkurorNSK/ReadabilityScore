import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main {
    public static void main(String[] args) throws IOException {
        long result = Files.lines(Paths.get("D:\\Downloads\\dataset_91065.txt")).mapToInt(Integer::parseInt).takeWhile(x -> x > 0).filter(x -> x % 2 == 0).count();
        System.out.println(result);
    }
}
