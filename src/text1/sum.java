package text1;

import java.util.Scanner;

public class sum {
    public class Main{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=sc.nextInt();
            }
            int pay=sum-sum/300*50;
            System.out.println(pay);
            if(sum%300==0){
                System.out.println("凑单完美零头刚好");
            }
            else{
                System.out.print("再买"+(300-sum%300)+"元可再减50");
            }
        }
    }
}
