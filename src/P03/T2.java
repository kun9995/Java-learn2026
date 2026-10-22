package P03;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b;
        if(a<=1) {
            b = a++ + 5;
            System.out.println(b);
        }
            else if(1<a && a<10) {
            b = a * 5 / 4;
            System.out.println(b);
        }
            else if(a>=10) {
            b = --a % 3;
            System.out.println(b);
        }

    }
}
