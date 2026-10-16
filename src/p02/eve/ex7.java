package p02.eve;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入圆的半径：");
        double radius = scanner.nextDouble();

        // 周长 = 2 * 半径 * 圆周率
        double perimeter = 2 * radius * Math.PI;

        System.out.println("周长=" + perimeter);

        scanner.close();
    }
}
