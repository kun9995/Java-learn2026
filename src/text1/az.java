package text1;

import java.util.Scanner;

public class az {
    public class Main{
        public static void main(String[]args){
            Scanner sc=new Scanner(System.in);
            int s=sc.nextInt();
            long n=sc.nextLong();
            long k=s-1+n;
            if(k%7+1==6||k%7+1==7){
                System.out.println("那天是周末重生者失算了");
            }else if(k%7+1==1||k%7+1==3||k%7+1==5){
                System.out.println("那天有高数早八快跑");
            }else {
                System.out.println("那天有大英早八认命吧");
            }
        }
    }
}
