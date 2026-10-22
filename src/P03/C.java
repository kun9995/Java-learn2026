package P03;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x * x + y * y <= 100) {
            System.out.print("(" + x + "," + y + ") inside the circle");
        } else {
            System.out.print("(" + x + "," + y + ") outside the circle");
        }
        sc.close();
    }
}

