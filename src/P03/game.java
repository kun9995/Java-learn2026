package P03;

import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char N = sc.next().charAt(0);
        int A = sc.nextInt();
        double H = sc.nextDouble();
        System.out.println("Name:" + N);
        System.out.println("Age:" + A);
        System.out.printf("Height(m):%.2f%n", H);
        sc.close();
    }
}
