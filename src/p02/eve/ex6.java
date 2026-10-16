package p02.eve;

import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();

        // 用取余运算判断奇偶：能被2整除为偶数，否则为奇数
        if (num % 2 == 0) {
            System.out.println(num + "是偶数");
        } else {
            System.out.println(num + "是奇数");
        }

        scanner.close();
    }
}
