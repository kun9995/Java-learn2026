package text1;

import java.util.Scanner;

public class Nt {;
    public class Main{
        public static long fact(long n){
            long result=1;
            while(n>1){
                result=result*n;
                n--;
            }
            return result;
        }
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            long n=sc.nextLong();
            long a=fact(n);
            System.out.println(a);
        }
    }
}
