package P03;

import java.util.Random;
import java.util.Scanner;

public class guessnumb {
    public static void main(String[] args) {
        Random r=new Random();
        int num=r.nextInt(100)+1;//1-100整数
        Scanner sc=new Scanner(System.in);
        int num2=sc.nextInt();
        if(num>num2){
            System.out.println("太小了");
        }else if(num<num2){
            System.out.println("太大了");
        }else{
            System.out.println("恭喜你");
        }
    }

}
