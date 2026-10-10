package p00;
import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args) {
        //Math.random()大于等于0，小于1的double类型的数
        int r = (int) (Math.random() * 100 + 1);
        Scanner input = new Scanner(System.in);
        int userNum;//变量声明
        int  c=0;
        do {
            System.out.println("请输入你的猜测，1到100之间的整数：");
            userNum = input.nextInt();//变量赋值语句
            if (userNum > r)
                System.out.println("猜大了");
            else if (userNum < r)
                System.out.println("猜小了");
            else
                System.out.println("猜对了");
            c++;
            if(c>10)
                break;
        }while(userNum!=r);
        System.out.println("您猜了"+c+"次");
    }
}