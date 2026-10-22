package P03;

import java.util.Scanner;

public class BMI {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double W=sc.nextDouble();
        double H=sc.nextDouble();
        if(W<=0||W>=727||H<=0||H>=2.72)
            System.out.print("input out of range");
        else{
            double BMI=W/(H*H);
            if(BMI<18.5){
                System.out.print("thin");
            }
            else if((BMI>=18.5)&&(BMI<24)){
                System.out.print("fit");
            }
            else if((BMI>=24)&&(BMI<28)){
                System.out.print("overweight");
            }
            else{
                System.out.print("fat");
            }
        }
    }
}

