package text1;

import java.util.Scanner;

public class wanmeishu {
    public class Main{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int  n=sc.nextInt();
            System.out.println(isPerfect(n)?n+":Yes":n+":No");
        }
        public static boolean isPerfect(int n){
            int sum=0;
            for(int i=1;i<=n/2;i++){
                if(n%i==0)
                    sum+=i;
            }
            return sum ==n;
        }
    }
}
