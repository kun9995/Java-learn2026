package JAVAlearning.own;

import java.util.Scanner;

public class Text  {
    public static void main(String[] args) {
//        彩票中奖案例，生成一个7位随机数表示彩票号码，键盘录入一个7位数表示彩票号码，判断用户输入的是否和系统生成的彩票号码一致
// 1. 生成一个7位随机数表示彩票号码
        int lottery = (int)(Math.random() * 9000000) + 10000000;
// 2.键盘录入一个7位数表示彩票号码
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个7位数表示彩票号码：");
        int number = scanner.nextInt();
        // 3.判断用户输入的是否和系统生成的彩票号码一致
        if (lottery == number) {
            System.out.println("恭喜中奖！");
        } else {
            System.out.println("很遗憾，没有中奖！");
        }


    }
}
