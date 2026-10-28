package text1;

import java.util.Scanner;

public class Prog2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int a=number/100;
        int b=number/10%10;
        int c=number%10;
        int sum=a*a*a+b*b*b+c*c*c;
        if(sum==number){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
