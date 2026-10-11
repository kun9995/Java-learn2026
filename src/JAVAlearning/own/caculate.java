package JAVAlearning.own;

import java.util.Scanner;

public class caculate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("请输入第一个整数: ");
            int a = sc.nextInt();
            System.out.print("请输入第二个整数: ");
            int b = sc.nextInt();

            System.out.println("和: " + (a + b));
            System.out.println("差: " + (a - b));
            System.out.println("积: " + (a * b));

            if (b != 0) {
                System.out.println("商: " + ((double) a / b));
            } else {
                System.out.println("商: 除数不能为零");
            }
        }
    }
}
