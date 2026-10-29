package p04;

import java.util.Random;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Random r=new Random();
            int num=r.nextInt(100)+1;
            Scanner sc=new Scanner(System.in);
            int num2=0;
            while(num!=num2){
                System.out.println("请输入数字");
                num2=sc.nextInt();
            if(num>num2){
                System.out.println("太小了");
            }else if(num<num2){
                System.out.println("太大了");
            }else{
                System.out.println("恭喜你");
            }
        }

    }
}

