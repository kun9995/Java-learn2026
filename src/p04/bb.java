package p04;

import java.util.Scanner;

public class bb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long f1 = 1;
        long f2 = 1;
        long fn = 1;
        for (int i = 3; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        System.out.println(isPrime(fn));
    }

    static boolean isPrime(long x) {
        if (x < 2) {
            return false;
        }
        for (long d = 2; d * d <= x; d++) {
            if (x % d == 0) {
                return false;
            }
        }
        return true;
    }
}
