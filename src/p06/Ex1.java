package p06;

import java.util.Scanner;

public class Ex1 {
        public static void main(String[] args) {
            System.out.println("计算一个数的阶乘，请输入数值：");
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();//输入一个整数
            int fact = 1;//记录阶乘
            int i = 1;
            do {
                fact *= i;//求阶乘  n!=1×2×3×...×(n-1)×n
                i++;
            } while (i <= num);
            System.out.println(num + "的阶乘为:" + fact);
        }
    }

