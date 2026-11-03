package JAVAlearning.own;

import java.util.Scanner;

public class reback {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            int b=sc.nextInt();
            int g=gcd(a,b);
            int lcm=a/g*b;
            System.out.printf("%d %d\n",g,lcm);
        }
        static int gcd(int a,int b){
            while(b!=0){
                int t=a%b;
                a=b;
                b=t;
            }
            return a;
        }
    }

