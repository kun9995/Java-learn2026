package JAVAlearning.own;

import java.util.Scanner;

public class nn {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            for(int i=2;i<=n;i++){
                if(isPrime(i)){
                    System.out.print(i+" ");
                }
            }
        }
        static boolean isPrime(int x){
            for(int d=2; d*d<=x;d++){
                if(x%d==0){
                    return false;
                }
            }
            return true;
        }
}
