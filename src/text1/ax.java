package text1;

import java.util.Scanner;

public class ax {
    public class Main{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int a=sc.nextInt();
            int m=sc.nextInt();
            if(n*a<=m){
                System.out.println("吃了不烧心");
            }
            else{
                System.out.println("钱包烧心");
            }
        }
    }
}
