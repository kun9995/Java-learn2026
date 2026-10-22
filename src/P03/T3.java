package P03;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();

        boolean leap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int days;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = leap ? 29 : 28;
                break;
            default:
                days = 31;
                break;
        }
        System.out.println(year + "年" + month + "月有" + days + "天");
    }
}
        }