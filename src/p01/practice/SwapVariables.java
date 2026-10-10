import java.util.Scanner;

public class SwapVariables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int temp = x;
        x = y;
        y = temp;

        System.out.println(x + " " + y);
        scanner.close();
    }
}
