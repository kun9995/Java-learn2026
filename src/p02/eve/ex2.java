package p02.eve;

import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner sc = new Scanner(System.in);

        // 接收用户输入的一个四位数
        int n = sc.nextInt();

        // 取出个位：对10取余，得到最右边一位
        // 例如 1234 % 10 = 4
        int ge = n % 10;

        // 取出十位：先除以10去掉个位，再对10取余
        // 例如 1234 / 10 = 123，123 % 10 = 3
        int shi = n / 10 % 10;

        // 取出百位：先除以100去掉个位和十位，再对10取余
        // 例如 1234 / 100 = 12，12 % 10 = 2
        int bai = n / 100 % 10;

        // 取出千位：直接除以1000，就是最左边一位
        // 例如 1234 / 1000 = 1
        int qian = n / 1000;

        // 把每一位数字加起来
        int sum = qian + bai + shi + ge;

        // 输出结果
        System.out.print(sum);
    }
}
