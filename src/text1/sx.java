package text1;

import java.util.Scanner;

public class sx {
    public class Main{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int num=sc.nextInt();
            System.out.println(num>=100&&num<999?isDaffodilf(num)?"yes":"no":"error");
            for(int i=100;i<=999;i++){
                if(isDaffodilf(i))System.out.println(i);
            }}
        public static boolean isDaffodilf(int num){
            int a=num/100;
            int b=num/10%10;
            int c=num%10;
            return a*a*a+b*b*b+c*c*c==num;
        }
    }

}
