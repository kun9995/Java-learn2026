package p02.eve;

import java.util.Scanner;

public class ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第一个整数：");
        int a = scanner.nextInt();

        System.out.print("请输入第二个整数：");
        int b = scanner.nextInt();

        System.out.println("交换前：a=" + a + ", b=" + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("交换后：a=" + a + ", b=" + b);

        scanner.close();
    }
}
