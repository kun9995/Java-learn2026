package P03;

import java.util.Scanner;

public class G  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char vip = sc.next().charAt(0);   // 是否会员：y/n
        double a = sc.nextDouble();        // 原价金额（关键：补上 a 的定义与读入）
        double b = 0;                      // 实际支付

        if (vip == 'y') {
            if (a >= 1000) {
                b = a * 0.75;              // 会员满1000：75折
            } else {
                b = a * 0.8;               // 会员：8折
            }
        } else {
            if (a >= 300) {
                b = a * 0.9;               // 非会员满300：9折
            } else {
                b = a;                     // 非会员不打折：实付=原价
            }
        }

        System.out.println("实际支付： " + b);
        sc.close();
    }
}

