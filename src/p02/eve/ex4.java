package p02.eve;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        // 创建键盘输入对象
        Scanner sc = new Scanner(System.in);

        // 从键盘输入两个整数
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 计算两个整数之和
        int sum = a + b;

        // 使用三元运算符判断和与20的大小关系
        // 条件成立返回"Yes"，否则返回"No"
        String result = (sum > 20) ? "Yes" : "No";

        // 打印结果
        System.out.println(result);
    }
}
