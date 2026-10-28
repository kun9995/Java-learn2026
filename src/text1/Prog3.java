package text1;

import java.util.Scanner;

public class Prog3 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int temp=sc.nextInt();
        if(temp>=100){
            System.out.println("水蒸气");
        }
        else if(temp>95&&temp<100){
            System.out.println("开水");
        }
        else if(temp>70&&temp<=95){
            System.out.println("热水");
        }
        else if(temp>40&&temp<=70){
            System.out.println("温水");
        }
        else{
            System.out.println("冷水");
        }
    }
}
