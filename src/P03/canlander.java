package P03;

import java.util.Scanner;

public class canlander {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int year = sc.nextInt();

        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 闰年判断：能被400整除，或能被4整除但不能被100整除
        boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        if (month == 2 && isLeap) {
            daysInMonth[1] = 29;
        }

        int days = daysInMonth[month - 1];

        System.out.println(monthNames[month - 1] + " " + year + " has " + days + " days");
    }
}
